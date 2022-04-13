package com.example.currencyconverterapp.repository

import com.example.currencyconverterapp.data.model.CurrencyResponse
import com.example.currencyconverterapp.utils.Resource

interface CurrencyRepo {

    suspend fun getRates(base: String, accessKey: String): Resource<CurrencyResponse>
}