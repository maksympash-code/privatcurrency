package com.example.privatcurrency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _uiState = MutableLiveData(MainUiState())
    val uiState: LiveData<MainUiState> = _uiState

    fun loadRates(date: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value?.copy(isLoading = true, error = null)

            try {
                val response = RetrofitProvider.api.getExchangeRates(date)
                val list = response.exchangeRate
                    .orEmpty()
                    .mapNotNull { it.toUi() }

                _uiState.value = MainUiState(
                    isLoading = false,
                    rates = list,
                    error = null
                )
            } catch (e: Exception) {
                e.printStackTrace() // тимчасово, щоб бачити в логах

                _uiState.value = _uiState.value?.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }
}