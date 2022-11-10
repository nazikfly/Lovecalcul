package com.geektech.lovecalcul

import android.app.Application
import androidx.room.Room
import com.geektech.lovecalcul.local.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object{
        lateinit var appDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase=
            Room.databaseBuilder(applicationContext,AppDataBase::class.java, "love_base")
            .allowMainThreadQueries().build()
    }
}