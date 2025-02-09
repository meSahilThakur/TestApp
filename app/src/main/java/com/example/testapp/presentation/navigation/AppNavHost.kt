package com.example.testapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.testapp.data.model.CardDetails
import com.example.testapp.presentation.detail.DetailScreenUI
import com.example.testapp.presentation.home.HomeScreenUI
import kotlin.reflect.typeOf

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreenUI(
                navController = navController,
            )
        }

        composable<DetailScreen>(
            typeMap = mapOf(
                typeOf<CardDetails>() to CustomNavType.CardDetailType
            )
        )
        { backStackEntry ->
            val detailData = backStackEntry.toRoute<DetailScreen>()
            DetailScreenUI(
                navController = navController,
//                value = detailData.value,
//                attributes = detailData.attributes,
//                title = detailData.title,
//                description = detailData.description,
//                image = detailData.image
                cardDetails = detailData.card
            )
        }
    }
}