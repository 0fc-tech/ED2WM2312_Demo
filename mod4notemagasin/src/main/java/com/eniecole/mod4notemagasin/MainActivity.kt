package com.eniecole.mod4notemagasin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eniecole.mod4notemagasin.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RatingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable    //NameVar : TypeVar = ConstructeurValDefault
fun RatingScreen(modifier: Modifier = Modifier,
                 ratingVM: RatingViewModel = viewModel()) {
        //NomDuParam = ValeurDuParam
    Column(modifier = modifier) {
        when(ratingVM.state){
            is RatingState.Initial -> {
                Text("Votre note : 0")
                Slider(value = 0f,
                    valueRange = 0f..10f,
                    steps = 10,
                    onValueChange = {ratingVM.updateRating(it.toInt())})
            }
            is RatingState.RequestFeedback-> {
                Text("Votre note : ${(ratingVM.state as RatingState.RequestFeedback).note}")
                Slider(value =(ratingVM.state as RatingState.RequestFeedback).note?.toFloat() ?:0f,
                    valueRange = 0f..11f,
                    steps = 10,
                    onValueChange = {ratingVM.updateRating(it.toInt())})
                TextField(
                    value="",
                    onValueChange = {},
                    label = {Text("Ah merde Y s'est passé quoi ?")}
                )
            }
            is RatingState.Success-> Text("Success")
            is RatingState.Finished-> Text("Finished")
        }
    }
}
