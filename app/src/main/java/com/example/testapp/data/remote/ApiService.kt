package com.example.testapp.data.remote

import com.example.testapp.data.model.Page
import retrofit2.http.GET

// interface for Retrofit API.
interface ApiService {
    @GET("/test/home")
    suspend fun getHomeData(): Page
}

