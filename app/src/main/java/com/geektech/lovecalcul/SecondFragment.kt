package com.geektech.lovecalcul

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.lovecalcul.databinding.FragmentSecondBinding
import com.geektech.lovecalcul.model.LoveModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
onGet()
        }
    private fun onGet(){
        val loveModel:LoveModel=arguments?.getSerializable("key") as LoveModel
        binding.firstName.text=loveModel.fname
        binding.secondName.text=loveModel.sname
        binding.percent.text=loveModel.percentage
        binding.result.text=loveModel.result
    }
}





