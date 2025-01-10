package com.example.testapp.di

import android.content.Context
import androidx.room.Room
import com.example.testapp.data.local.CardDao
import com.example.testapp.data.local.CardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideCardDatabase(@ApplicationContext context: Context): CardDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CardDatabase::class.java,
            "card_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCardDao(cardDatabase: CardDatabase): CardDao {
        return cardDatabase.cardDao()
    }
}