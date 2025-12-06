package com.example.privatcurrency

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PrivatApi {
    @GET("p24api/exchange_rates")
    suspend fun getExchangeRates(
        @Query("date") date: String,
        @Query("json") json: String,
    ) : ExchangeResponse
}