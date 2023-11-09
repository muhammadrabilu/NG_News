package com.rabilu.ngnews.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    properties: MyTextFieldProperties,
    modifier: Modifier = Modifier,
) {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
            properties.text = it
        },
        label = { Text(text = properties.labelText.toString()) },
        leadingIcon = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = properties.leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Divider(
                    modifier = Modifier
                        .width(2.dp)
                        .height(24.dp)
                )
            }
        },
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 24.dp,
            bottomEnd = 24.dp,
            bottomStart = 24.dp
        ),
        keyboardOptions = properties.keyboardOptions,
        keyboardActions = properties.keyboardActions,
    )
}

@Preview
@Composable
fun MyTextFieldPreview() {
    Surface {
        MyTextField(
            properties = MyTextFieldProperties(text = "Hello"),
            modifier = Modifier.padding(16.dp)
        )
    }
}

data class MyTextFieldProperties(
    var text: String? = null,
    val labelText: String? = null,
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    val keyboardActions: KeyboardActions = KeyboardActions.Default,
    val leadingIcon: ImageVector = Icons.Default.Person
)