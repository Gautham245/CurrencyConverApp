package com.example.currencyconverterapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.currencyconverterapp.utils.CurrencyEvent
import currencyconverterapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: CurrencyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnConvert.setOnClickListener {
            viewModel.convert(
                activityMainBinding.etFrom.text.toString(),
                activityMainBinding.spFromCurrency.selectedItem.toString(),
                activityMainBinding.spToCurrency.selectedItem.toString(),
            )
        }

        lifecycleScope.launchWhenCreated {
            viewModel.conversion.collect { event ->
                when (event) {
                    is CurrencyEvent.Success -> {
                        activityMainBinding.progressBar.isVisible = false
                        activityMainBinding.tvResult.setTextColor(Color.BLACK)
                        activityMainBinding.tvResult.setText(event.resutString)
                    }
                    is CurrencyEvent.Failure -> {
                        activityMainBinding.progressBar.isVisible = false
                        activityMainBinding.tvResult.setTextColor(Color.RED)
                        activityMainBinding.tvResult.setText(event.errorText)
                    }
                    is CurrencyEvent.Loading -> {
                        activityMainBinding.progressBar.isVisible = true
                    }
                    is CurrencyEvent.Empty -> {
                        activityMainBinding.progressBar.isVisible = false
                    }
                    else -> Unit
                }
            }
        }
    }
}