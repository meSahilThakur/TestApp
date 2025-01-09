package com.example.testapp.domain.usecases

import com.example.testapp.data.model.Card
import com.example.testapp.domain.repository.HomeRepository
import com.example.testapp.utils.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend fun invoke(): Flow<ResultState<List<Card>>> {
        return repository.getHomeData()
    }
}
