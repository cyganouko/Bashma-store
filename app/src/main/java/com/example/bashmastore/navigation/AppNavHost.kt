package com.example.bashmastore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bashmastore.ui.theme.ladswear.LadsWearScreen
import com.example.bashmastore.ui.theme.nike.NikeScreen
import com.example.bashmastore.ui.theme.screens.home.HomeScreen
import com.example.bashmastore.ui.theme.screens.login.LoginScreen
import com.example.bashmastore.ui.theme.screens.mensoutfit.MensOutfitScreen
import com.example.bashmastore.ui.theme.screens.products.AddProductsScreen
import com.example.bashmastore.ui.theme.screens.products.ViewProductsScreen
import com.example.bashmastore.ui.theme.screens.signup.SignupScreen
import com.example.bashmastore.ui.theme.screens.sneakers.SneakersScreen
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

        composable(ADD_PRODUCTS_URL) {
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL) {
            ViewProductsScreen(navController = navController)
        }
        composable(ROUT_SNEAKERS){
            SneakersScreen(navController = navController)
        }
        composable(ROUT_NIKE){
            NikeScreen(navController = navController)
        }

        composable(ROUT_LADSWEAR){
            LadsWearScreen(navController = navController)
        }

        composable(ROUT_MENSOUTFIT){
            MensOutfitScreen(navController = navController)
        }














    }
}













