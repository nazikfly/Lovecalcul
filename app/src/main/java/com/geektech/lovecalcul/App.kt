package com.geektech.lovecalcul

import android.app.Application
import com.geektech.lovecalcul.model.LoveApi
import com.geektech.lovecalcul.model.RetrofitService

class App: Application() {

    companion object{
        lateinit var api:LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        api=RetrofitService().api
    }
}