package com.dmotpan.kata_mvvm.currentweather

import android.graphics.Color
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dmotpan.kata_mvvm.api.ApiService
import com.dmotpan.kata_mvvm.api.RetrofitProvider
import com.dmotpan.kata_mvvm.api.model.WeatherResponse
import com.dmotpan.kata_mvvm.api.status.Resource
import com.dmotpan.kata_mvvm.databinding.ActivityCurrentWeatherBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

@ExperimentalCoroutinesApi
class CurrentWeatherActivity : AppCompatActivity() {
    private val viewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CurrentWeatherViewModel(
                CurrentWeatherInteractor(RetrofitProvider.get().create(ApiService::class.java))
            ) as T
        }
    }

    private val viewModel: CurrentWeatherViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(CurrentWeatherViewModel::class.java)
    }
    private val binding by lazy {
        ActivityCurrentWeatherBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.degrees.setOnClickListener {
            viewModel.onTemperatureClick()
        }
        // TODO
    }

    private fun showKonfetti() {
        binding.konfetti.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12))
            .setPosition(-50f, binding.konfetti.width + 50f, -50f, -50f)
            .streamFor(300, 3500L)
    }

    private fun showLoading() {
        binding.error.visibility = GONE
        binding.progress.visibility = VISIBLE
        binding.degrees.visibility = GONE
    }

    private fun showSuccess(weather: Resource<WeatherResponse>) {
        binding.error.visibility = GONE
        binding.progress.visibility = GONE
        binding.degrees.visibility = VISIBLE
        val degrees = weather.data?.currentWeather?.tempCelsius?.toInt()?.toString()
        binding.degrees.text = degrees
    }

    private fun showError() {
        binding.degrees.visibility = GONE
        binding.progress.visibility = GONE
        binding.error.visibility = VISIBLE
    }
}
