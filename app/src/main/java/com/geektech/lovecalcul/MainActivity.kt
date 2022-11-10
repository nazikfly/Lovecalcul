package com.geektech.lovecalcul


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.geektech.lovecalcul.databinding.ActivityMainBinding
import com.geektech.lovecalcul.local.Preference
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var prefs:Preference
    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs.showBoarding(true)
        if (prefs.getIsShowBoarding()){
            navController.navigate(R.id.loveFragment)
        }

    }


}









