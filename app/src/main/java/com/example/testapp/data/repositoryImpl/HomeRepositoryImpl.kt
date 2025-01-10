package com.example.testapp.data.repositoryImpl

import com.example.testapp.data.local.CardDao
import com.example.testapp.data.local.CardEntity
import com.example.testapp.data.model.Card
import com.example.testapp.data.remote.ApiService
import com.example.testapp.domain.repository.HomeRepository
import com.example.testapp.utils.ResultState
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val cardDao: CardDao
): HomeRepository {
    override suspend fun getHomeData(): Flow<ResultState<List<Card>>> = callbackFlow {
        trySend(ResultState.Loading)
        try {
            val response = apiService.getHomeData()
            val cards = response.page.cards

            val cardEntities = cards.map { card ->
                CardEntity(
//                    id = card.card_type,
                    card_type = card.card_type,
                    card = card.card
                )
            }
            cardDao.deleteAllCards()        //delete old data
            cardDao.insertCards(cardEntities)      // save cards to room
            trySend(ResultState.Success(cards))
        } catch (e: Exception) {
            val cachedCards = cardDao.getAllCards().map { entity ->
                Card(
                    card_type = entity.card_type,
                    card = entity.card
                )
            }
            if (cachedCards.isNotEmpty()) {
                trySend(ResultState.Success(cachedCards))
            } else {
            trySend(ResultState.Error(e.message ?: "Unknown error"))
                }
        }
        awaitClose{
            close()
        }
    }
}