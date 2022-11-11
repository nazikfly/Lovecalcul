package com.geektech.lovecalcul.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.lovecalcul.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase :RoomDatabase(){

abstract fun loveDao():LoveDao

}