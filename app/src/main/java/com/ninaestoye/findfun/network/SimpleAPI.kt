package com.ninaestoye.findfun.network

import com.ninaestoye.findfun.model.QueryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleAPI {

    @GET("/api.php")
    suspend fun fetchQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String
    ): Response<QueryResponse>;
}