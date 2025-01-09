package com.example.testapp.domain.repository

import com.example.testapp.data.model.Card
import com.example.testapp.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHomeData(): Flow<ResultState<List<Card>>>
}

