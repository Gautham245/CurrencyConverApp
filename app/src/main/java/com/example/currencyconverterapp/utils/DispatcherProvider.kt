package com.example.currencyconverterapp.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val manin: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}