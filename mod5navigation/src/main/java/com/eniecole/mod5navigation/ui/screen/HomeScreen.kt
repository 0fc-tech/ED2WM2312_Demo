package com.eniecole.mod5navigation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier,email: String) {
    Column{
        Text("Bienvenue sur votre espace")
        Text("Email : $email")
    }

}