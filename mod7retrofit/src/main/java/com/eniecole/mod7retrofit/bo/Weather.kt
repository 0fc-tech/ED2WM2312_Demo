package com.eniecole.mod7retrofit.bo

import com.google.gson.annotations.SerializedName

//Structure de données reçues du serveur
data class WeatherResponse(val hourly : HourlyData)

//Structure pour chaque heure
data class HourlyData(
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temp: List<Double>,
    @SerializedName("wind_speed_10m")
    val windSpeed:List<Double>
)