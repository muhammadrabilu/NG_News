package com.rabilu.ngnews.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabilu.ngnews.R
import com.rabilu.ngnews.ui.theme.Black40
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MyToast(
    modifier: Modifier = Modifier,
    onDismiss: (Boolean) -> Unit,
    show: Boolean = false,
    message: String
) {
    val scope = rememberCoroutineScope()
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Black40
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Filled.Bookmark,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(24.dp),
                color = Color.White
            )
            Text(
                text = message,
                color = Color.White,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.times)),
                    fontWeight = FontWeight(400)
                ),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
    LaunchedEffect(show) {
        if (show) {
            scope.launch {
                delay(3000)
                onDismiss(false)
            }
        }
    }

}

@Preview
@Composable
fun MyToastPreview() {
    Surface {
        MyToast(onDismiss = {}, message = "Saved for Later")

    }
}