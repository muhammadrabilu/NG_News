package com.rabilu.ngnews.ui.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rabilu.ngnews.R
import com.rabilu.ngnews.data.remote.api.Resource
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.model.NewsResponse
import com.rabilu.ngnews.ui.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Destination
fun HomeScreen(
    navigator: DestinationsNavigator,
    resource: Resource<List<Article>>,
    refresh: () -> Unit
) {
    val state = rememberLazyListState()
    val configuration = LocalConfiguration.current
    var newsList by remember { mutableStateOf(NewsResponse().articles) }
    val context = LocalContext.current
    var isLoading by remember {
        mutableStateOf(false)
    }
    val refreshState = rememberPullRefreshState(refreshing = isLoading, onRefresh = { refresh() })
    LaunchedEffect(resource) {
        if (resource.data != null) {
            newsList = resource.data
        }
        when (resource) {

            is Resource.Error -> {
                Log.e("TAG", "HomeScreen: error ${resource.errorMessage}")
                isLoading = false
                Toast.makeText(context, resource.errorMessage, Toast.LENGTH_SHORT).show()
            }

            is Resource.Loading -> {
                isLoading = true
            }

            is Resource.Success -> {
                isLoading = false
                if (resource.data != null) newsList = resource.data
            }
        }
    }

    Surface {
        Column(
            Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Text(modifier = Modifier.padding(top = 32.dp), text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily(Font(R.font.times)),
                            fontWeight = FontWeight(700),
                            fontSize = 32.sp
                        )
                    ) {
                        append("NG")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontFamily = FontFamily(Font(R.font.times)),
                            fontWeight = FontWeight(700),
                            fontSize = 32.sp
                        )
                    ) {
                        append(" News Edit")
                    }
                })
                Spacer(modifier = Modifier.height(32.dp))
                Divider()
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Wednesday, 30 March", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                        )
                    )

                    Text(
                        text = "Editions", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.times)),
                            textDecoration = TextDecoration.Underline
                        )
                    )
                }
                Divider()

                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "${newsList.size} Stories",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                    )
                )
            }

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .pullRefresh(refreshState)
                    .verticalScroll(state = rememberScrollState())
            ) {
                val (newRowList, loadingIndicator) = createRefs()
                LazyRow(
                    modifier = Modifier.constrainAs(newRowList) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    },
                    verticalAlignment = Alignment.CenterVertically,
                    state = state,
                    contentPadding = PaddingValues(16.dp)
                ) {
                    itemsIndexed(newsList) { index, item ->
                        NewsItem(
                            news = item,
                            index = index + 1,
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 16.dp)
                                .fillMaxHeight()
                                .width(configuration.screenWidthDp.dp - 72.dp)
                                .clickable {
                                    navigator.navigate(DetailsScreenDestination(item))
                                }
                        )
                    }
                }
                PullRefreshIndicator(isLoading,
                    refreshState,
                    modifier = Modifier.constrainAs(loadingIndicator) {
                        top.linkTo(newRowList.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(EmptyDestinationsNavigator, Resource.Success(), refresh = {})
}