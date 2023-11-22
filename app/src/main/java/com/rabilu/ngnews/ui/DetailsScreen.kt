package com.rabilu.ngnews.ui

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.NavigateBefore
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Copyright
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.rabilu.ngnews.R
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.ui.common.MyToast
import com.rabilu.ngnews.ui.saved_article.SavedArticleViewModel
import com.rabilu.ngnews.ui.theme.Black40
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun DetailsScreen(
    navigator: DestinationsNavigator,
    news: Article,
) {
    val savedArticleViewModel = hiltViewModel<SavedArticleViewModel>()
    val context = LocalContext.current
    val savedArticle = savedArticleViewModel.saveArticle.collectAsState(initial = news).value

    var article by remember {
        mutableStateOf(news)
    }
    LaunchedEffect(savedArticle) {
        savedArticleViewModel.getSavedArticle(article.publishedAt!!)
        article.isSaved = savedArticle.isSaved
    }

    var showToast by remember { mutableStateOf(false) }
    var toastMessage by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { }, navigationIcon = {
                Icon(imageVector = Icons.AutoMirrored.Outlined.NavigateBefore,
                    contentDescription = "GO back",
                    tint = Black40,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickable {
                            navigator.popBackStack()
                        })
            }, actions = {
                IconButton(onClick = {
                    if (article.isSaved) {
                        article = news.copy(isSaved = false)
                        savedArticleViewModel.deleteSaveArticle(article)
                        toastMessage = "Removed"
                        showToast = true
                    } else {
                        article = news.copy(isSaved = true)
                        savedArticleViewModel.saveArticle(article = article)
                        toastMessage = "Save for Later"
                        showToast = true
                    }
                    savedArticleViewModel.getSavedArticle(article.publishedAt!!)
                }) {
                    Icon(
                        imageVector = if (savedArticle.isSaved) Icons.Outlined.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = "Save for Later",
                        tint = Black40,
                    )
                }

                IconButton(modifier = Modifier.padding(horizontal = 16.dp), onClick = {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.apply {
                        putExtra(Intent.EXTRA_TEXT, article.url)
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(intent, "Where to share?"))
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = "Share",
                        tint = Black40,
                    )
                }
            })
        },
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = it.calculateBottomPadding(),
                    top = it.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                )
                .verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = article.urlToImage,
                    contentDescription = "new Picture",
                    modifier = Modifier
                        .height(300.dp)
                        .padding(top = 21.dp),
                    contentScale = ContentScale.Crop
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Copyright,
                        contentDescription = null,
                        modifier = Modifier.size(10.dp),
                        tint = Black40
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet consectetur. Sodales nibh ",
                        modifier = Modifier.padding(start = 4.dp),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.times)),
                            fontWeight = FontWeight(400),
                        )
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = news.title.toString(),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline,
                                fontSize = 12.sp,
                            )
                        ) {
                            append("By ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 12.sp,
                            )
                        ) {
                            append(article.source?.name)
                        }
                    }, style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.times)),

                        )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = article.content.toString(), style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(400),
                    )
                )
            }

            AnimatedVisibility(
                visible = showToast,
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                MyToast(modifier = Modifier.fillMaxWidth(),
                    show = showToast,
                    message = toastMessage,
                    onDismiss = { show -> showToast = show })
            }

        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        navigator = EmptyDestinationsNavigator,
        news = Article(),
    )
}