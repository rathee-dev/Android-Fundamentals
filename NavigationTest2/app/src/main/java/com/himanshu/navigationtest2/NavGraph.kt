package com.himanshu.navigationtest2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable(
            route = "details_screen?name={name}&age={age}",arguments = listOf(
                navArgument("name") { nullable = true },
                navArgument("age") { defaultValue = "0" }
            )
        ) {backStackEmpty->
            val name =backStackEmpty.arguments?.getString("name")
            val age = backStackEmpty.arguments?.getString("age")?.toIntOrNull() ?: 0
            DetailsScreen(myName = name, myAge = age)
        }
    }
}
