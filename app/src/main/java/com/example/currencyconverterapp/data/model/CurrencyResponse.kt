package com.example.currencyconverterapp.data.model


import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    val base: String,
    val date: String,
    val rates: Rates
)