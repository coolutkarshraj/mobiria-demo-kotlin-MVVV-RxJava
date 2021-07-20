package com.utkarsh.mvvmrxjavakotlin.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
/*
* Initializing retrofit clas
* after the creating client
* for sending in header we put while initializing
*
* */
class RetroInstance {

    companion object {

        private val client = OkHttpClient.Builder().apply {
            addInterceptor(HeaderInterceptor())
        }.build()

        private const val baseURL = "https://loyaltyhubapp.com/drawino/webservices/"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}