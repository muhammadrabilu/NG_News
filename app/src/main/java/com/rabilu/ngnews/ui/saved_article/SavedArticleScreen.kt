package com.rabilu.ngnews.ui.saved_article

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rabilu.ngnews.R
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.ui.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Composable
@Destination
fun SavedArticleScreen(
    navigator: DestinationsNavigator, savesArticles: List<Article> = listOf()
) {

    Scaffold {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val (articles, header) = createRefs()
            Text(modifier = Modifier
                .constrainAs(header) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .fillMaxWidth()
                .padding(top = 32.dp), text = "Saved", style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.times)),
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center
            ))
            LazyColumn(
                modifier = Modifier.constrainAs(articles) {
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }, contentPadding = PaddingValues(16.dp)
            ) {
                items(savesArticles) { item ->
                    SavedArticleItem(article = item, modifier = Modifier.clickable {
                        navigator.navigate(
                            DetailsScreenDestination(
                                news = item
                            )
                        )
                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun SavedArticleScreenPreview() {
    SavedArticleScreen(navigator = EmptyDestinationsNavigator)
}