package com.geektech.lovecalcul.local

import android.content.Context
import android.content.SharedPreferences

class Preference(private val context: Context) {

   private var preference: SharedPreferences =
   context.getSharedPreferences("simple_data", Context.MODE_PRIVATE)

   fun getIsShowBoarding() :Boolean {
   return preference.getBoolean("is_show", false)
   }
   fun showBoarding(isShow: Boolean) {
   preference.edit().putBoolean("is_show", isShow).apply()
   }

}