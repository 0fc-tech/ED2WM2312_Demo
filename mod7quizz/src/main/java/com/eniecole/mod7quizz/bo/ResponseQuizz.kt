package com.eniecole.mod7quizz.bo

import com.google.gson.annotations.SerializedName
import java.util.ArrayList


data class Question(
    val id: Int,
    val question: String,
    val description: String?,
    val category: String,
    val explanation: String,
    val answers: Map<String,String?>,
    /*
   {
        "answer_a" : "sdklfge"
        "answer_b" : "kldsnvjkvre"
        "answer_c" : null
        "answer_d" : null
        "answer_e" : null
   }
     */
    @SerializedName("correct_answers")
    val correctAnswers: Map<String,String>
/*
   {
        "answer_a_correct" : "true"
        "answer_b_correct" : "false"
        "answer_c_correct" : "true"
        "answer_d_correct" : "false"
        "answer_e_correct" : "false"
   }
     */

)