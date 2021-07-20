package com.utkarsh.mvvmrxjavakotlin.network

import okhttp3.Interceptor
import okhttp3.Response
/*
* Interceptor class for sending header data in retrofit
*
* */
class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("APP-USER", "lovebake")
                .addHeader("APP-PWD", "df014f04b7e13046a2d057c9f2ce3e2b")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build()
        )
    }
}