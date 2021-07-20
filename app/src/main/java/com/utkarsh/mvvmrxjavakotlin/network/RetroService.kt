package com.utkarsh.mvvmrxjavakotlin.network

import LoginResponseModel
import TicketResponseModel
import io.reactivex.Observable
import retrofit2.http.*


interface RetroService {
    // interface for doing Login for user
    @FormUrlEncoded
    @POST("user/login")
    fun doLogin(@Field("user_email")
                user_email: String,@Field ("user_password")user_password:String
                     ,@Field("user_device_token")user_device_token:String,
                @Field("user_device_type")user_device_type:String
                ,@Field("device_cart_id")device_cart_id:String): Observable<LoginResponseModel>

    // interface for getting all the tickets from web
    @FormUrlEncoded
    @POST("tickets/get_tickets")
    fun getAllTicket(@Field("access_token")
                     access_token: String,@Field ("category_id")category_id:String
                    ,@Field("language")language:String): Observable<TicketResponseModel>
}