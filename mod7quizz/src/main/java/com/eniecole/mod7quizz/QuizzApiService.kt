package com.eniecole.mod7quizz

import com.eniecole.mod7quizz.bo.Question
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizzApiService {
    @GET("/api/v1/questions")
    fun getQuizzQuestions(
        @Query("apiKey") key: String,
        @Query("category") category: String,
        @Query("tags") tags: String,
    ): Call<List<Question>>
}