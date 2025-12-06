package com.example.privatcurrency

data class ExchangeRateDto(
    val baseCurrency: String?,
    val currency: String?,
    val saleRateNB: Double?,
    val purchaseRateNB: Double?,
    val saleRate: Double?,
    val purchaseRate: Double?
)