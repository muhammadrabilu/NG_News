package com.rabilu.ngnews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Article
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.rabilu.ngnews.network.api.Resource
import com.rabilu.ngnews.ui.auth.AuthenticationViewModel
import com.rabilu.ngnews.ui.destinations.HomeScreenDestination
import com.rabilu.ngnews.ui.destinations.OnBoardingScreenOneDestination
import com.rabilu.ngnews.ui.home.HomeScreen
import com.rabilu.ngnews.ui.theme.Black40
import com.rabilu.ngnews.ui.theme.BottomBarBackground
import com.rabilu.ngnews.ui.theme.NGNewsTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NGNewsTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val currenDestination = navController.currentDestinationAsState()
                val authenticationViewModel = hiltViewModel<AuthenticationViewModel>()
                val launch = authenticationViewModel.launch.value
                var selectedScreen by remember { mutableStateOf(HomeScreenDestination) }
                var showBottomBar by remember {
                    mutableStateOf(false)
                }
                LaunchedEffect(key1 = currenDestination.value) {
                    showBottomBar = when (navController.currentDestination?.route) {
                        HomeScreenDestination.route -> true
                        else -> false
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    AnimatedVisibility(visible = showBottomBar) {
                        BottomAppBar(
                            containerColor = BottomBarBackground,
                            contentColor = Black40
                        ) {
                            NavigationBarItem(
                                selected = false,
                                onClick = { /*TODO*/ },
                                icon = {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Rounded.Article,
                                        contentDescription = "Home Screen"
                                    )
                                },
                                label = { Text(text = "Home") },
                                colors = NavigationBarItemDefaults.colors(

                                )
                            )
                            NavigationBarItem(selected = false, onClick = { /*TODO*/ },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Rounded.BookmarkBorder,
                                        contentDescription = "Saved Screen"
                                    )
                                }, label = {
                                    Text(text = "Saved")
                                }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = { /*TODO*/ },
                                label = {
                                    Text(text = "Settings")
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Settings,
                                        contentDescription = "Settings Screen"
                                    )
                                })
                        }
                    }

                }) {
                    DestinationsNavHost(
                        modifier = Modifier.padding(it),
                        startRoute = if (launch) OnBoardingScreenOneDestination else HomeScreenDestination,
                        navGraph = NavGraphs.root,
                        navController = navController
                    ) {
                        composable(HomeScreenDestination) {
                            val newsViewModel = hiltViewModel<NewsViewModel>()
                            val result =
                                newsViewModel.newsList.collectAsState(Resource.Loading()).value
                            HomeScreen(
                                navigator = destinationsNavigator,
                                resource = result
                            )
                        }
                    }
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