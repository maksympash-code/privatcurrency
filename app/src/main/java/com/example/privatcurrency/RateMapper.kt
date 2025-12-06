package com.example.privatcurrency

fun ExchangeRateDto.toUi(): RateUi? {
    val cur = currency ?: return null
    val buy = purchaseRate ?: purchaseRateNB ?: return null
    val sell = saleRate ?: saleRateNB ?: return null

    return RateUi(
        currency = cur,
        purchaseText = "Buy: %.4f".format(buy),
        saleText = "Sale: %4.f".format(sell)
    )
}