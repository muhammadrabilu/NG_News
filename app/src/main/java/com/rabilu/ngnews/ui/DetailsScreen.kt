package com.rabilu.ngnews.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.rabilu.ngnews.domain.model.News
import com.rabilu.ngnews.ui.theme.Black40
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun DetailsScreen(
    navigator: DestinationsNavigator,
    news: News
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
                    Icon(
                        imageVector = Icons.Outlined.BookmarkBorder,
                        contentDescription = "Save for Later",
                        tint = Black40,
                    )
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = "Save for Later",
                        tint = Black40,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                })
        },
    ) {
        Column(modifier = Modifier.padding(it)) {
            AsyncImage(
                model = news.imageUrl,
                contentDescription = "new Picture",
                modifier = Modifier.height(200.dp),
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
                text = news.headline,
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
                        append("By")
                    }
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            fontSize = 12.sp,
                        )
                    ) {
                        append(news.id)
                    }
                },
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.times)),

                    )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = news.description,
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
        news = News(
            "1",
            headline = "Mohbad: Naira Marley relseases last coversation with late singer, police arrest Sam Larry",
            description = "Lorem ipsum dolor sit amet consectetur. Sodales nibh quam pulvinar nunc augue diam. Dui vel faucibus donec volutpat enim amet." +
                    "Lorem ipsum dolor sit amet consectetur. Sodales nibh quam pulvinar nunc augue .",
            imageUrl = "data:image/jpeg;base64,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"
        )
    )
}