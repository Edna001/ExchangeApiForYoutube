package com.hellocompany.apiforyoutube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hellocompany.apiforyoutube.Request.RequestApi
import com.hellocompany.apiforyoutube.Response.ExchangeResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.exchangeratesapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val postsApi = retrofit.create(RequestApi::class.java)
    private val response = postsApi.getAllPosts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        response.enqueue(object : Callback<ExchangeResponse>{
            override fun onFailure(call: Call<ExchangeResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<ExchangeResponse>, response: Response<ExchangeResponse>) {
                val mResponse = response.body()
                usd_text.text = "USD: ${mResponse!!.rates!!.USD.toString()}"
                rub_text.text = "RUB: ${mResponse!!.rates!!.RUB.toString()}"
            }

        })

    }
}
