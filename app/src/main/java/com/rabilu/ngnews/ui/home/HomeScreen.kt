package com.rabilu.ngnews.ui.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.rabilu.ngnews.R
import com.rabilu.ngnews.domain.model.NewsResponse
import com.rabilu.ngnews.network.api.Resource
import com.rabilu.ngnews.ui.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Composable
@Destination
fun HomeScreen(
    navigator: DestinationsNavigator, resource: Resource<NewsResponse>
) {
    var selectedScreen by remember { mutableStateOf(HomeScreenDestination) }
    val state = rememberLazyListState()
    val configuration = LocalConfiguration.current
    var newsList by remember {
        mutableStateOf(NewsResponse().articles)
    }
    val context = LocalContext.current
    LaunchedEffect(resource) {

        when (resource) {
            is Resource.Error -> {
                Log.d("TAG", "HomeScreen: error ${resource.errorMessage}")
            }

            is Resource.Loading -> {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }

            is Resource.Success -> {
                Log.d("TAG", "HomeScreen: ${resource.data}")
                if (resource.data != null)
                    newsList = resource.data.articles
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
            LazyRow(
                Modifier.wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                state = state,

                ) {
                itemsIndexed(newsList) { index, item ->
                    NewsItem(
                        news = item,
                        index = index,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxHeight()
                            .width(configuration.screenWidthDp.dp - 72.dp)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(EmptyDestinationsNavigator, Resource.Success())
}