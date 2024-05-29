package com.eniecole.mod5navigation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInScreen(modifier: Modifier = Modifier, onClickSignIn : (email : String)->Unit) {
    var email by remember{ mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Spacer(Modifier.weight(1f))
        TextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Email")})
        TextField(
            value = "",
            onValueChange = {},
            label = {Text("Mot de passe")})
        Spacer(Modifier.weight(1f))
        ElevatedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {onClickSignIn(email)}) {Text("Se connecter")}
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }) {Text("S'inscrire")}
        Spacer(Modifier.weight(1f))
    }
}