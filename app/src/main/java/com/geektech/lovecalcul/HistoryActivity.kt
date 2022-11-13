package com.geektech.lovecalcul

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.geektech.lovecalcul.databinding.ActivityHistoryBinding
import com.geektech.lovecalcul.local.room.AppDataBase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.historyTv.movementMethod = ScrollingMovementMethod()

        showHistory()
    }

    private fun showHistory() {
        App.dp.loveDao().getLove().observe(this,Observer { historyList ->
            var history = " "
            historyList.forEach{ model ->
                history +=
                    " ${model.firstName}\n ${model.secondName}\n ${model.percentage}\n ${model.result}\n"
            }
            App.dp.loveDao().getAllLove().observe(this){
                binding.historyTv.text = historyList.toString()

            }
        })
    }
}





