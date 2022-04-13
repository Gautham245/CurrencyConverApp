package com.example.currencyconverterapp.utils

sealed class CurrencyEvent {
    class Success(val resutString: String) : CurrencyEvent()
    class Failure(val errorText: String) : CurrencyEvent()
    object Loading : CurrencyEvent()
    object Empty : CurrencyEvent()
}
