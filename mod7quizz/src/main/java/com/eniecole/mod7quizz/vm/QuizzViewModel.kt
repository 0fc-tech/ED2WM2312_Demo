package com.eniecole.mod7quizz.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniecole.mod7quizz.QuizzApiService
import com.eniecole.mod7quizz.RetrofitClient
import com.eniecole.mod7quizz.bo.Question
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizzViewModel: ViewModel() {
    var question : Question? by mutableStateOf(null)
    var response :String? by mutableStateOf(null)
        private set
    var resultUser : String by mutableStateOf("")
    var lettreCorrectAnswers : List<String> by mutableStateOf(listOf<String>())

    private fun checkUserResponse(){
        resultUser = if(question?.correctAnswers?.get("${response}_correct") == "true")
            "Bonne réponse"
        else{
            "Mauvaise réponse"
        }

    }
    fun reply(response: String){
        this.response = response;
        checkUserResponse()
    }


    fun fetchQuestion(){
        response = null
        resultUser =""

        viewModelScope.launch(Dispatchers.IO) {
            RetrofitClient.quizzApiService
                .getQuizzQuestions(
                    "eZFq54inj2Tu2nytKZW11fip5kfQxDq7pKXGyOwN",
                    "Code",
                    "JavaScript"
                ).enqueue(object : Callback<List<Question>>{
                    override fun onResponse(
                        call: Call<List<Question>>,
                        response: Response<List<Question>>
                    ) {
                        question = response.body()?.get(0)
                        println(response)
                        question?.let{
                            lettreCorrectAnswers = it.correctAnswers.filter{ (_, valeur) ->valeur == "true"}.map {
                                    (lettre, _) -> lettre.removeSuffix("_correct")
                            }
                        }

                    }

                    override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                        println("failure")
                        println(t.message)
                    }

                })
        }
    }
}
//
//sealed class QuizzState{
//    object Initial: QuizzState()
//    data class CorrectionUserResponse(): QuizzState()
//    data class NewQuestions(): QuizzState()
//
//}