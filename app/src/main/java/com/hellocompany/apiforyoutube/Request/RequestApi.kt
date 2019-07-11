package com.hellocompany.apiforyoutube.Request

import com.hellocompany.apiforyoutube.Response.ExchangeResponse
import retrofit2.Call
import retrofit2.http.GET

interface RequestApi {

    @GET("latest")
    fun getAllPosts(): Call<ExchangeResponse>

}