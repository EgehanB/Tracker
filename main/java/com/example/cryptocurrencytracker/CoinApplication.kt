package com.example.cryptocurrencytracker

import android.app.Application
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class CoinApplication: Application() {


    interface CoinService {
        @GET("coins/{id}")
        fun getcoinbyid(@Path("id") id: String?): Call<Coin>?

        @GET("coins/list")
        fun getcoins(): Call<List<Coin>>

    }

    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.coingecko.com/api/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create(CoinService::class.java)
}