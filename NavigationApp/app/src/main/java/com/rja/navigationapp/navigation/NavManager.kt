package com.rja.navigationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rja.navigationapp.views.DetailView
import com.rja.navigationapp.views.HomeView

@Composable
fun NavManager() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home") {
            HomeView(navController = navController)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType},
            navArgument("opcional") { type = NavType.StringType},

        )) {
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController = navController, id, opcional)
        }
    }

}
