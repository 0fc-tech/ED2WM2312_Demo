package com.eniecole.mod3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eniecole.mod3compose.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Surface {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {Text("MichelTopBar") })
                        },
                        modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Column(modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()) {
                            Text(text = "Hello World")
                            Icon(imageVector = Icons.Default.Favorite,
                                contentDescription = null)
                            Text("Hello Again",modifier = Modifier.padding(16.dp))
                            CircularProgressIndicator(modifier = Modifier
                                .padding(16.dp)
                                .background(
                                    Color.Red
                                ))
                            Spacer(Modifier.weight(1f))
                            TextField(value = "Champ à remplir", onValueChange = {})
                            Spacer(Modifier.weight(1f))
                            OutlinedButton(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = { /*TODO*/ }
                            ) {Text("HI")}
                        }
                    }
                }

            }
        }
    }
}