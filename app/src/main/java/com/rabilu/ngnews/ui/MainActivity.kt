package com.rabilu.ngnews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rabilu.ngnews.ui.destinations.HomeScreenDestination
import com.rabilu.ngnews.ui.theme.NGNewsTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NGNewsTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val isFirstTimeOpen by remember {
                    mutableStateOf(true)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Text(
        text = "Hello!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NGNewsTheme {
        Greeting()
    }
}