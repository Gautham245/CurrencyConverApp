package com.example.currencyconverterapp.data

import com.example.currencyconverterapp.data.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("latest")
    suspend fun getRates(
        @Query("access_key") accessKey: String,
    ): Response<CurrencyResponse>
}