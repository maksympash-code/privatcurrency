package com.example.privatcurrency

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.privatcurrency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()
    private val ratesAdapter = RatesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvRates.apply {
            adapter = ratesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.btnLoad.setOnClickListener {
            val date = binding.etDate.text.toString().ifEmpty { "01.12.2014" }
            viewModel.loadRates(date)
        }

        viewModel.uiState.observe(this) { state ->
            binding.pbLoading.visibility =
                if (state.isLoading) View.VISIBLE else View.GONE

            ratesAdapter.submit(state.rates)

            state.error?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

    }
}