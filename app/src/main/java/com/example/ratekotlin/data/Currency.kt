package com.example.ratekotlin.data

import com.example.ratekotlin.model.Rate
import retrofit2.Response
import retrofit2.http.GET

interface Currency {
    @GET("latest?apikey=afa8f360-9993-11ec-bd40-4bfba891ba9b")
    //suspend fun getCurrency() : Response<HashMap<Currency,Currency>>
    suspend fun getCurrency(): Response<Rate>

}