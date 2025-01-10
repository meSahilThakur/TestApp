package com.example.testapp.di

import com.example.testapp.data.local.CardDao
import com.example.testapp.data.remote.ApiService
import com.example.testapp.data.repositoryImpl.HomeRepositoryImpl
import com.example.testapp.domain.repository.HomeRepository
import com.example.testapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideHomeRepository(
        apiService: ApiService, // Example dependency
        cardDao: CardDao // Example dependency
    ): HomeRepository {
        return HomeRepositoryImpl(apiService, cardDao)
    }
}