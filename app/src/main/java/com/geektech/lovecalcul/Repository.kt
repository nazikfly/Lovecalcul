package com.geektech.lovecalcul

import androidx.lifecycle.MutableLiveData
import com.geektech.lovecalcul.model.LoveApi
import com.geektech.lovecalcul.model.LoveModel
import com.geektech.lovecalcul.local.room.LoveDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi, private val dao:LoveDao){
    fun getCalculate(firstName: String,secondName: String):MutableLiveData<LoveModel>{
        var liveLoveModel=MutableLiveData<LoveModel>()
        api.calculate(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    liveLoveModel.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
            }
        })
        return liveLoveModel
    }
     fun insert(loveModel: LoveModel){
        dao.insert(loveModel)
    }
}



