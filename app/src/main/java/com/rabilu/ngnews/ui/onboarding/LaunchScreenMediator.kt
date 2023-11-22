package com.rabilu.ngnews.ui.onboarding

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.rabilu.ngnews.ui.destinations.HomeScreenDestination
import com.rabilu.ngnews.ui.destinations.OnBoardingScreenOneDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
@RootNavGraph(start = true)
fun LaunchScreenMediator(
    fistLaunch: Boolean?,
    navigator: DestinationsNavigator
) {
    LaunchedEffect(fistLaunch) {
        if (fistLaunch!!) {
            navigator.popBackStack()
            navigator.navigate(OnBoardingScreenOneDestination)
        } else {
            navigator.popBackStack()
            navigator.navigate(HomeScreenDestination)
        }
    }
}