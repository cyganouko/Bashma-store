package com.example.bashmastore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bashmastore.ui.theme.screens.home.HomeScreen
import com.example.bashmastore.ui.theme.screens.login.LoginScreen
import com.example.bashmastore.ui.theme.screens.signup.SignupScreen
import com.example.bashmastore.ui.theme.screens.splash.SplashScreen


@Composable
fun <NavHostController> AppNavHost(
    modifier: Modifier = Modifier,
    navController: androidx.navigation.NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

            composable(ROUT_HOME) {
               HomeScreen(navController = navController)
            }

            composable(ROUT_SPLASH){
                SplashScreen(navController = navController)
            }


        composable(ROUT_LOGIN){
            LoginScreen(navController = navController)
        }

        composable(ROUT_SIGNUP){
            SignupScreen(navController = navController)
        }













    }
}




