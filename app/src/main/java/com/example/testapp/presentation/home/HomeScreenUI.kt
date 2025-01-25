package com.example.testapp.presentation.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.testapp.presentation.components.HomeCard
import com.example.testapp.presentation.navigation.DetailScreen

@Composable
fun HomeScreenUI(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
) {
    val homeState by viewModel.homeState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchHomeData()
    }

    when {
        homeState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        homeState.error.isNotEmpty() -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = homeState.error, color = Color.Red)
            }
        }

        homeState.data.isNotEmpty() -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(homeState.data) { card ->
                    Log.d("HomeScreenUI", "Card: ${card.card}")
                    HomeCard(
                        card = card,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(
                                    DetailScreen(
//                                        value = card.card.value,
//                                        attributes = card.card.attributes,
//                                        title = card.card.title,
//                                        description = card.card.description,
//                                        image = card.card.image
                                        card = card.card
                                    )
                                )
                            },
                    ) // HomeCard accepts `Card`
                }
            }
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No data available")
            }
        }
    }
}

