package com.nurhaq.reader.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nurhaq.reader.screens.ReaderSplashScreen
import com.nurhaq.reader.screens.home.Home
import com.nurhaq.reader.screens.login.ReaderLoginScreen

@ExperimentalComposeUiApi
@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ReaderScreens.ReaderHomeScreen.name
    ) {
        composable(
            ReaderScreens.SplashScreen.name
        ) {
            ReaderSplashScreen(navController = navController)
        }

        composable(
            ReaderScreens.LoginScreen.name
        ){
            ReaderLoginScreen(navController = navController)
        }

        composable(
            ReaderScreens.ReaderHomeScreen.name
        ) {
            Home(navController = navController)
        }

    }
}