package com.example.currencyconverterapp.repository

import com.example.currencyconverterapp.data.CurrencyApi
import com.example.currencyconverterapp.data.model.CurrencyResponse
import com.example.currencyconverterapp.utils.Resource
import javax.inject.Inject

class CurrencyRepoImpl @Inject constructor(private val api: CurrencyApi) : CurrencyRepo {

    override suspend fun getRates(base: String, accessKey: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(accessKey)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else
                Resource.Error(response.message() + " code : " + response.code().toString())

        } catch (e: Exception) {
            Resource.Error(e.message ?: "An Error Occurred")
        }
    }
}