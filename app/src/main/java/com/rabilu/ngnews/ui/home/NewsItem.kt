package com.rabilu.ngnews.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.rabilu.ngnews.domain.model.News
import com.rabilu.ngnews.ui.theme.Black40
import com.rabilu.ngnews.ui.theme.BottomBarBackground
import com.rabilu.ngnews.ui.theme.WhiteGrey

@Composable
fun NewsItem(modifier: Modifier = Modifier, news: News, index: Int = 0) {
    Column(
        modifier = modifier
            .background(BottomBarBackground)
            .padding(start = 16.dp, end = 16.dp, top = 64.dp, bottom = 16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F8F8))
        ) {
            val (image, header, divider, description) = createRefs()

            Image(
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.rectangle_3),
                contentDescription = "Article Image"
            )

            Column(modifier = Modifier
                .constrainAs(header) {
                    top.linkTo(image.bottom, margin = (-64).dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = 32.dp)) {
                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(Black40)
                        .padding(8.dp),
                    text = "0$index",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                        color = WhiteGrey,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    text = news.headline,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(8.dp),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                        textAlign = TextAlign.Justify
                    )
                )
            }

            Divider(modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(vertical = 16.dp, horizontal = 16.dp)
            )

            Text(
                modifier = Modifier
                    .constrainAs(description) {
                        top.linkTo(divider.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                text = news.description,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.times)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Justify
                )
            )
        }
    }

}


@Preview
@Composable
fun NewsItemPreview() {
    Surface {
        NewsItem(
            news = News(
                "1",
                headline = "Mohbad: Naira Marley relseases last coversation with late singer, police arrest Sam Larry",
                description = "Lorem ipsum dolor sit amet consectetur. Sodales nibh quam pulvinar nunc augue diam. Dui vel faucibus donec volutpat enim amet." +
                        "Lorem ipsum dolor sit amet consectetur. Sodales nibh quam pulvinar nunc augue .",
                imageUrl = ""
            ),
        )
    }
}