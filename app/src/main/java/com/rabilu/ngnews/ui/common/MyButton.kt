package com.rabilu.ngnews.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabilu.ngnews.R
import com.rabilu.ngnews.ui.theme.Black40

@Composable
fun MyButton(modifier: Modifier = Modifier, textLabel: String, onClick: () -> Unit) {
    Button(modifier = modifier
        .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Black40),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(10.dp),
        onClick = { onClick() }) {
        Text(
            text = textLabel, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(500)
            )
        )
    }
}

@Preview
@Composable
fun MyButtonPreview() {
    Surface {
        MyButton(textLabel = "Text", onClick = {})
    }
}