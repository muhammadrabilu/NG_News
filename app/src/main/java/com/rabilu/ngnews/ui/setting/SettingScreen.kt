package com.rabilu.ngnews.ui.setting

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabilu.ngnews.R
import com.rabilu.ngnews.ui.theme.Black40
import com.rabilu.ngnews.ui.theme.WhiteGrey
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun SettingScreen() {
    val context = LocalContext.current
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = it.calculateBottomPadding(), start = 16.dp, end = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                text = "Setting",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.times)),
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center
                )
            )

            Text(
                text = "Feed Us Back", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.times)),
                    fontWeight = FontWeight(400),

                    )
            )

            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(Black40)
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(Color.White, shape = RoundedCornerShape(100))
                        .border(width = 4.dp, shape = RoundedCornerShape(100), color = WhiteGrey)
                        .size(80.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_SENDTO)
                            intent.apply {
                                data = Uri.parse("mailto:")
                            }
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Feed Back")
                            intent.putExtra(
                                Intent.EXTRA_EMAIL,
                                arrayOf("rabilumuhammad@gmail.com")
                            )
                            intent.putExtra(Intent.EXTRA_TEXT, "The is very helpful to me!")
                            context.startActivity(intent)
                        },
                ) {

                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .background(Color.White, shape = RoundedCornerShape(100))
                            .border(
                                width = 2.dp, shape = RoundedCornerShape(100), color = WhiteGrey
                            )
                            .size(70.dp),
                    ) {
                        Icon(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(vertical = 8.dp),
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "We’d love to hear your feedback",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                    )
                )
                Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
            }
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Report a bug",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                    )
                )
                Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
            }
            Divider()


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "PERMISSIONS",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(400),
                    )
                )
                Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
            }
            Divider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Privacy policy",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                    )
                )
                Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
            }
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Terms and Conditions",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                    )
                )
                Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
            }
            Divider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "ACCOUNT",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(400),
                    )
                )
                Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
            }
            Divider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Restore Purchase",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                    )
                )
                Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
            }
            Divider()
        }
    }
}

@Preview
@Composable
fun SettingScreenPreview() {
    SettingScreen()
}