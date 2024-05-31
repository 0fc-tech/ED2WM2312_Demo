package com.eniecole.mod7retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eniecole.mod7retrofit.ui.theme.DemonstrationsTheme
import com.eniecole.mod7retrofit.vm.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListWeather(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ListWeather(modifier: Modifier = Modifier, vm : WeatherViewModel = viewModel()) {
    LazyColumn(modifier = modifier) {
        vm.weatherData?.let { weather->
            itemsIndexed(weather.time){ index,time->
                Row(modifier = Modifier.padding(8.dp)){
                    Text(text = time)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "${weather.temp[index]}°C")
                }
            }
        }
    }
}
