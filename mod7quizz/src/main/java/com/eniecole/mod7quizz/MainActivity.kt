package com.eniecole.mod7quizz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eniecole.mod7quizz.ui.theme.DemonstrationsTheme
import com.eniecole.mod7quizz.vm.QuizzViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuizzQuestions(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun QuizzQuestions(modifier: Modifier = Modifier,
                   vm: QuizzViewModel = viewModel()) {
    Column(modifier = modifier) {
        vm.question?.let { question->
            Text(question.question)
            Text(question.description ?:"")
            ButtonsResponse(answers = question.answers,
                lettreCorrectAnswers = vm.lettreCorrectAnswers,
                response = vm.response,
                onSubmitResponse = {vm.reply(it)}
            )
        }
        Text(vm.resultUser)
        OutlinedButton({vm.fetchQuestion()}){
            Text("Question suivante")
        }
    }
}

@Composable
fun ButtonsResponse(modifier: Modifier = Modifier,
                    answers : Map<String,String?>,
                    lettreCorrectAnswers : List<String>,
                    response:String? ,
                    onSubmitResponse : (String) -> Unit = {}) {
    Column{
        answers.forEach { (lettre, valeur) ->
            valeur?.let {
                Button({onSubmitResponse(lettre)},
                    colors = ButtonDefaults.buttonColors(
                        containerColor =if(
                            lettreCorrectAnswers.contains(lettre) && response != null)
                            Color.Green
                        else if(response != null)
                            Color.Red
                        else
                            MaterialTheme.colorScheme.primary)
                ) {
                    Text(valeur.toString())
                }
            }
        }
    }

}