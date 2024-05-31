package com.eniecole.mod7retrofit.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniecole.mod7retrofit.bo.HourlyData
import com.eniecole.mod7retrofit.bo.WeatherResponse
import com.eniecole.mod7retrofit.service.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel: ViewModel() {
    //récupérer en mutableState les données météo
    var weatherData : HourlyData? by mutableStateOf(null)

    init{fetchWeather(50.6292,3.0571)}

    private fun fetchWeather(lat:Double, lng: Double){
        viewModelScope.launch(Dispatchers.IO) {
            RetrofitClient.weatherService.getWeatherData(
                latitude = lat, longitude = lng,
                current = "temperature_2m,wind_speed_10m",
                hourly = "temperature_2m"
            ).enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                    if(response.isSuccessful)
                        weatherData = response.body()?.hourly
                }
                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    println("Pasd'accès Internet")
                }

            })
        }
    }
}