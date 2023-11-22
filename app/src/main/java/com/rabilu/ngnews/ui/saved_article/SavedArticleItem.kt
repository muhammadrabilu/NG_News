package com.rabilu.ngnews.ui.saved_article

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rabilu.ngnews.R
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.ui.theme.Black40

@Composable
fun SavedArticleItem(modifier: Modifier = Modifier, article: Article) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val (description, icons) = createRefs()
        Text(
            modifier = Modifier
                .constrainAs(description) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(icons.start)
                    width = Dimension.fillToConstraints
                }
                .padding(end = 8.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            text = article.description!!,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.times)),
                fontSize = 12.sp,
                fontWeight = FontWeight(700)
            )
        )
        Row(
            modifier = Modifier.constrainAs(icons) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
        ) {
            Divider(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .width(1.dp)
                    .height(24.dp),
                color = Black40
            )
            Icon(imageVector = Icons.Outlined.Bookmark, contentDescription = null)
        }

    }
}

@Preview
@Composable
fun SavedArticleItemPreview() {
    Surface {
        SavedArticleItem(
            modifier = Modifier.fillMaxWidth(),
            Article(description = "This is s test description")
        )
    }
}