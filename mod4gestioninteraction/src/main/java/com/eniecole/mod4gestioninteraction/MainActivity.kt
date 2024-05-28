package com.eniecole.mod4gestioninteraction

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eniecole.mod4gestioninteraction.ui.theme.DemonstrationsTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecetteGateauChocolat(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RecetteGateauChocolat(modifier: Modifier = Modifier,
                          recetteVM: RecetteViewModel = viewModel()) {
    Row(modifier = modifier){
        IconButton(onClick = { recetteVM.decNbPersonnes() }) {
            Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Remove")
        }
        Column{
            Text("Nombre de personnes 👨 : ${recetteVM.nbPersonnes }")
            Text("Nombre d'oeufs : ${recetteVM.nbOeufs }")
            Text("Grammes Farine : ${recetteVM.gFarine }")
        }
        IconButton(onClick = { recetteVM.incNbPersonnes() }) {
            Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Add")
        }
    }
}
@Composable
fun Formulaire(modifier: Modifier = Modifier) {
    var prenom by remember { mutableStateOf("") }
    var nom by rememberSaveable { mutableStateOf("") }
    var dateNaissance by rememberSaveable { mutableStateOf("") }
    Scaffold{ innerPadding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            TextField(
                value = prenom,
                onValueChange = { prenom = it },
                label = { Text("Prénom") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = nom,
                onValueChange = {
                    nom = it
                    Log.i(TAG, "Formulaire: $it", )
                    if(it.length>20)
                        Log.e(TAG, "Formulaire: Attention le nom est un peu long" )
                },
                label = { Text("Nom") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = dateNaissance,
                onValueChange = { dateNaissance = it },
                label = { Text("Date de Naissance") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text("Valider")
            }
        }
    }
}
