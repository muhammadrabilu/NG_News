package com.rabilu.ngnews.ui.onboarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabilu.ngnews.ui.theme.Black40
import com.rabilu.ngnews.ui.theme.WhiteGrey

@Composable
fun CurrentScreenIndicator(
    modifier: Modifier = Modifier,
    isCurrent: Boolean
) {
    Canvas(modifier = modifier.size(16.dp)) {
        drawCircle(color = if (isCurrent) Black40 else WhiteGrey)
    }
}

@Preview
@Composable
fun CurrentScreenIndicatorPreview() {
    Surface {
        CurrentScreenIndicator(isCurrent = true)
    }
}