package com.rabilu.ngnews.ui.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabilu.ngnews.R
import com.rabilu.ngnews.ui.common.MyButton
import com.rabilu.ngnews.ui.common.MyTextField
import com.rabilu.ngnews.ui.common.MyTextFieldProperties
import com.rabilu.ngnews.ui.destinations.RegistrationScreenDestination
import com.rabilu.ngnews.ui.theme.Black40
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Composable
@Destination
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    val userTextFieldProperties = MyTextFieldProperties(
        labelText = "User Name", keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
    val passwordTextFieldProperties = MyTextFieldProperties(
        labelText = "Password", keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        leadingIcon = Icons.Outlined.Lock
    )
    val context = LocalContext.current
    Surface {
        Column(
            Modifier
                .padding(horizontal = 32.dp)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = "Sign In", style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = FontFamily(Font(R.font.times)),
                    fontWeight = FontWeight(700),
                )
            )
            MyTextField(
                modifier = Modifier.padding(top = 32.dp),
                properties = userTextFieldProperties
            )
            MyTextField(
                modifier = Modifier.padding(top = 32.dp),
                properties = passwordTextFieldProperties
            )
            MyButton(
                textLabel = "Sign In", modifier = Modifier.padding(top = 32.dp),
            ) {
                if (!userTextFieldProperties.text.isNullOrBlank())
                    Toast.makeText(context, userTextFieldProperties.text, Toast.LENGTH_SHORT).show()
            }

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google_logo),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(
                        text = "Sign in with Google", style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.times)),
                            fontWeight = FontWeight(400),
                            color = Black40
                        )
                    )
                }
            }

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_fb_logo),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(
                        text = "Sign in with Facebook", style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.times)),
                            fontWeight = FontWeight(400),
                            color = Black40
                        )
                    )
                }
            }

            TextButton(
                modifier = Modifier.padding(top = 16.dp),
                onClick = { navigator.navigate(RegistrationScreenDestination) }
            ) {
                Text(
                    text = "Don’t have an account? Sign Up!",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(400),
                        color = Black40
                    )
                )
            }

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(EmptyDestinationsNavigator)
}