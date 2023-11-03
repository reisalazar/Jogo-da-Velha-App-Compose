package com.example.reisalazar.jogodavelha.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.reisalazar.jogodavelha.navigation.AppScreens
import com.example.reisalazar.jogodavelha.screen.HomeScreen
import com.example.reisalazar.jogodavelha.screen.history.HistoryScreen

//@Composable
//fun GameNavigation() {
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = AppScreens.InitialScreen.name
//    ) {
//
//        composable("detail/{name}/{id}") { backStackEntry ->
//            // Extracting the arguments from the route
//            val name= backStackEntry.arguments?.getString("name")
//            val id= backStackEntry.arguments?.getString("id")
//
//            // Check if arguments are not null and render the screenf
//            if (name!= null && id!= null) {
//                HistoryScreen(name, id)
//            }
//        }
//
//        composable(AppScreens.InitialScreen.name) {
//            HomeScreen()
//        }
//        composable(
//            AppScreens.HistoryScreen.name + "/{game}",
//            arguments = listOf(navArgument(name = "game"){type= NavType.StringType})
//        ) {
//                backStackEntry ->
//            HistoryScreen(navController = navController,backStackEntry.arguments)
//        }
//    }
//}