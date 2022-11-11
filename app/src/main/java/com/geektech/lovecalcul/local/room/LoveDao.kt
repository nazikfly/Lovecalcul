package com.geektech.lovecalcul.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.lovecalcul.model.LoveModel

@Dao
interface LoveDao {

    @Insert suspend fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table")
    fun getLove():LiveData<List<LoveModel>>

    @Query("SELECT*FROM love_table ORDER BY firstName ASC")
    fun getAllLove():LiveData<List<LoveModel>>

}