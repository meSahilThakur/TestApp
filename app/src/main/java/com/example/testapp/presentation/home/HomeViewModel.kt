package com.example.testapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.model.Card
import com.example.testapp.domain.usecases.GetHomeDataUseCase
import com.example.testapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    private val _homeData = MutableStateFlow(GetHomeState())
    val homeState = _homeData.asStateFlow()

//    init {
//        fetchHomeData()
//    }

    fun fetchHomeData() {

        viewModelScope.launch{
            getHomeDataUseCase.invoke().collectLatest {
                when(it){
                    is ResultState.Loading -> {
                        _homeData.value = GetHomeState(isLoading = true)
                    }
                    is ResultState.Error -> {
                        _homeData.value = GetHomeState(error = it.message)
                        }
                    is ResultState.Success -> {
                        _homeData.value = GetHomeState(data = it.data)
                    }
                }
            }
        }
    }
}

data class GetHomeState(
    val isLoading: Boolean = false,
    val data: List<Card> = emptyList(),
    val error: String = ""
)


