package com.himanshu.navigationtest

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_screen") {

        composable("first_screen") {
            FirstScreen { name, age ->
                navController.navigate("second_screen/$name/$age")
            }
        }
        composable(
            "second_screen/{name}/{age}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.IntType })
        ) {
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getInt("age") ?: 0
            SecondScreen(
                name,
                age,
                { navController.navigate("first_screen") },
                { navController.navigate("third_screen") })
        }
        composable("third_screen") {
            ThirdScreen {
                navController.navigate("first_screen")
            }
        }
    }
}