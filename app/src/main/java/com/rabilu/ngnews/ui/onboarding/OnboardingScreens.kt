package com.rabilu.ngnews.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rabilu.ngnews.R
import com.rabilu.ngnews.data.DataStoreManager
import com.rabilu.ngnews.ui.common.MyButton
import com.rabilu.ngnews.ui.destinations.HomeScreenDestination
import com.rabilu.ngnews.ui.destinations.OnBoardingScreenFourDestination
import com.rabilu.ngnews.ui.destinations.OnBoardingScreenOneDestination
import com.rabilu.ngnews.ui.destinations.OnBoardingScreenThreeDestination
import com.rabilu.ngnews.ui.destinations.OnBoardingScreenTwoDestination
import com.rabilu.ngnews.ui.theme.NGNewsTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


//@Composable
//@Destination
//@OnboardingNavGraph
//fun OnboardingScreenContainer(
//    navigator: DestinationsNavigator
//) {
//    var showScreenIndicator by remember {
//        mutableStateOf(false)
//    }
//    val navController = rememberNavController()
//    val currentDestination = navController.currentDestinationAsState().value
//
//    navController.addOnDestinationChangedListener { _, destination, _ ->
//        Log.d(
//            "TAG", "OnboardingScreenContainer: ${destination.route}"
//        )
//        showScreenIndicator = destination.route != OnBoardingScreenOneDestination.route
//    }
//    Surface {
//        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//            val (indicator, navhost) = createRefs()
//
//            DestinationsNavHost(navGraph = NavGraphs.root,
//                navController = navController,
//                modifier = Modifier.constrainAs(navhost) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    bottom.linkTo(indicator.top)
//                    width = Dimension.fillToConstraints
//                })
//
////            if (showScreenIndicator) {
////                Row(modifier = Modifier
////                    .padding(start = 32.dp, end = 32.dp, bottom = 40.dp)
////                    .constrainAs(indicator) {
////                        bottom.linkTo(parent.bottom)
////                        start.linkTo(parent.start)
////                        end.linkTo(parent.end)
////                    }) {
////                    CurrentScreenIndicator(
////                        isCurrent = currentDestination?.route == OnBoardingScreenTwoDestination.route
////                    )
////
////                    CurrentScreenIndicator(
////                        modifier = Modifier.padding(horizontal = 16.dp),
////                        isCurrent = currentDestination?.route == OnBoardingScreenThreeDestination.route
////                    )
////
////                    CurrentScreenIndicator(
////                        isCurrent = currentDestination?.route == OnBoardingScreenFourDestination.route
////                    )
////                }
////            }
//        }
//    }
//}

//@Preview
//@Composable
//fun OnboardingScreensContainerPreview() {
//    OnboardingScreenContainer(EmptyDestinationsNavigator)
//}

@Composable
@Destination
@RootNavGraph(start = true)
fun OnBoardingScreenOne(
    navigator: DestinationsNavigator
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (colu, button, indicator) = createRefs()
            Column(modifier = Modifier.constrainAs(colu) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
                Text(
                    modifier = Modifier.padding(start = 32.dp, top = 40.dp),
                    text = "NG News Edit",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontSize = 32.sp,
                        fontWeight = FontWeight(700)
                    )
                )
                Text(
                    modifier = Modifier.padding(start = 32.dp, top = 8.dp),
                    text = "For those who love it short and precise",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400)
                    )
                )

                Image(
                    painter = painterResource(id = R.drawable.onboarding_1),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 72.dp, end = 32.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
            MyButton(textLabel = "Begin", modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 24.dp, end = 24.dp, bottom = 64.dp)) {
                navigator.navigate(OnBoardingScreenTwoDestination)
            }
        }
    }
}

@Composable
@Destination
fun OnBoardingScreenTwo(
    navigator: DestinationsNavigator
) {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.onboarding_2),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Skip",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 32.dp, top = 64.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000)
                    )
                )
            }
            Column {

            }
            Column(
                Modifier
                    .padding(bottom = 64.dp, start = 32.dp, end = 32.dp)
                    .background(color = Color(0xFFECF4F6), shape = RoundedCornerShape(16.dp))
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Editor’s \n Hand-Picked",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = "Lorem ipsum dolor sit amet consectetur. Imperdiet vel duis dictum fringilla id egestas. Cras faucibus dictum urna metus amet massa. Tincidunt pharetra etiam ultricies enim in.",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 46.dp, start = 32.dp, end = 32.dp, bottom = 40.dp),
                    textAlign = TextAlign.Center,
                )
                MyButton(
                    textLabel = "Continue",
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 32.dp)
                ) {
                    navigator.navigate(OnBoardingScreenThreeDestination)
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                CurrentScreenIndicator(
                    isCurrent = true
                )

                CurrentScreenIndicator(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    isCurrent = false
                )

                CurrentScreenIndicator(
                    isCurrent = false
                )
            }
        }
    }
}

@Composable
@Destination
fun OnBoardingScreenThree(
    navigator: DestinationsNavigator
) {

    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.onboarding_3),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Skip",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 32.dp, top = 64.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000)
                    )
                )
            }

            Column(
                Modifier
                    .padding(bottom = 64.dp, start = 32.dp, end = 32.dp)
                    .background(color = Color(0xFFECF4F6), shape = RoundedCornerShape(16.dp))
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Thoughtful and \nFocused",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = "Lorem ipsum dolor sit amet consectetur. Imperdiet vel duis dictum fringilla id egestas. Cras faucibus dictum urna metus amet massa. Tincidunt pharetra etiam ultricies enim in.",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 46.dp, start = 32.dp, end = 32.dp, bottom = 40.dp),
                    textAlign = TextAlign.Center,
                )
                MyButton(
                    textLabel = "Continue",
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 32.dp)
                ) {
                    navigator.navigate(OnBoardingScreenFourDestination)
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                CurrentScreenIndicator(
                    isCurrent = false
                )
                CurrentScreenIndicator(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    isCurrent = true
                )

                CurrentScreenIndicator(
                    isCurrent = false
                )
            }
        }
    }
}

@Composable
@Destination
fun OnBoardingScreenFour(
    navigator: DestinationsNavigator,
) {
    val context = LocalContext.current
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.onboarding_4),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Skip",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 32.dp, top = 64.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000)
                    )
                )
            }

            Column(
                Modifier
                    .padding(bottom = 64.dp, start = 32.dp, end = 32.dp)
                    .background(color = Color(0xFFECF4F6), shape = RoundedCornerShape(16.dp))
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Read Less, \nUnderstand  More",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = "Lorem ipsum dolor sit amet consectetur. Imperdiet vel duis dictum fringilla id egestas. Cras faucibus dictum urna metus amet massa. Tincidunt pharetra etiam ultricies enim in.",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.times)),
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 46.dp, start = 32.dp, end = 32.dp, bottom = 40.dp),
                    textAlign = TextAlign.Center,
                )
                MyButton(
                    textLabel = "Continue",
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 32.dp)
                ) {
                    navigator.popBackStack(OnBoardingScreenOneDestination, true)
                    navigator.popBackStack(OnBoardingScreenTwoDestination, true)
                    navigator.popBackStack(OnBoardingScreenThreeDestination, true)
                    navigator.navigate(HomeScreenDestination)
                    CoroutineScope(IO).launch {
                        DataStoreManager(context).updateLaunchStatus()
                    }
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                CurrentScreenIndicator(
                    isCurrent = false
                )

                CurrentScreenIndicator(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    isCurrent = false
                )

                CurrentScreenIndicator(
                    isCurrent = true
                )
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    NGNewsTheme {
        OnBoardingScreenTwo(navigator = EmptyDestinationsNavigator)
    }
}
