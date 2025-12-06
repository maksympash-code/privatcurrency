package com.example.privatcurrency

data class ExchangeResponse(
    val date: String?,
    val bank: String?,
    val baseCurrency: Int?,
    val baseCurrencyLit: String?,
    val exchangeRate: List<ExchangeRateDto>?,
)

