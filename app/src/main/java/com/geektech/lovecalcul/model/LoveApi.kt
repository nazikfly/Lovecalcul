package com.geektech.lovecalcul.model


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun calculate(
        @Query("fname")firstName:String,
        @Query("sname")secondName:String,
        @Header("X-RapidAPI-Key") key:String="387b467bb8msh7d5ab89eb6d6e31p1d6d27jsn61471e0002a5",
        @Header("X-RapidAPI-Host") host:String="love-calculator.p.rapidapi.com",
    ): Call<LoveModel>
}