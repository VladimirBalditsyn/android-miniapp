package com.balditsyn.stackoveflow.data.remote

import com.balditsyn.stackoveflow.data.model.Answer
import com.balditsyn.stackoveflow.data.model.Question
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StackOverflowApi {
    @GET("/questions?page=1&pagesize=100&order=asc&sort=creation&tagged=Android&site=stackoverflow&filter=withbody")
    suspend fun getQuestions(): Response<ListResponse<Question>>

    @GET("/questions/{questionId}/answers?order=desc&sort=votes&site=stackoverflow&filter=withbody")
    suspend fun getAnswers(@Path("questionId") questionId: Long): Response<ListResponse<Answer>>

    companion object {
        const val STACKOVERFLOW_API_URL = "https://api.stackexchange.com/2.2/"
    }
}

