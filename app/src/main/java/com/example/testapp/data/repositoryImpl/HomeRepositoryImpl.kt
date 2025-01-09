package com.example.testapp.data.repositoryImpl

import com.example.testapp.data.model.Card
import com.example.testapp.data.remote.ApiService
import com.example.testapp.domain.repository.HomeRepository
import com.example.testapp.utils.ResultState
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val apiService: ApiService): HomeRepository {
    override suspend fun getHomeData(): Flow<ResultState<List<Card>>> = callbackFlow {
        trySend(ResultState.Loading)
        try {
            val response = apiService.getHomeData()
            trySend(ResultState.Success(response.page.cards))
        } catch (e: Exception) {
            trySend(ResultState.Error(e.message ?: "Unknown error"))
        }
        awaitClose{
            close()
        }
    }
}