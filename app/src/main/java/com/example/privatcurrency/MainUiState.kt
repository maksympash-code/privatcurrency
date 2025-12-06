package com.example.privatcurrency

data class MainUiState(
    val isLoading: Boolean = false,
    val rates: List<RateUi> = emptyList(),
    val error: String? = null,
)