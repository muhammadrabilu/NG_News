package com.rabilu.ngnews.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.NavigateBefore
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Copyright
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import coil.compose.AsyncImage
import com.rabilu.ngnews.R
import com.rabilu.ngnews.domain.model.Article
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
    savedArticles: List<Article>,
    savedArticle: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.NavigateBefore,
                        contentDescription = "GO back",
                        tint = Black40,
                        modifier = Modifier.padding(horizontal = 16.dp)

                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.BookmarkBorder,
                            contentDescription = "Save for Later",
                            tint = Black40,
                        )
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = "Save for Later",
                            tint = Black40,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }


                })
        },
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = it.calculateBottomPadding(),
                    top = it.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                )
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = news.urlToImage,
                contentDescription = "new Picture",
                modifier = Modifier
                    .height(300.dp)
                    .padding(top = 21.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.Copyright,
                    contentDescription = null,
                    modifier = Modifier
                        .size(10.dp),
                    tint = Black40
                )
                Text(
                    text = "Lorem ipsum dolor sit amet consectetur. Sodales nibh ",
                    modifier = Modifier
                        .padding(start = 4.dp),
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
                        append(news.source?.name)
                    }
                },
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.times)),

                    )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = news.content.toString(),
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.times)),
                    fontWeight = FontWeight(400),
                )
            )
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        navigator = EmptyDestinationsNavigator,
        news = Article(),
        savedArticles = listOf(),
        savedArticle = {}
    )
}