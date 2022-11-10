package com.geektech.lovecalcul.onBoard.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.geektech.lovecalcul.R
import com.geektech.lovecalcul.databinding.FragmentOnBoardingBinding
import com.google.android.datatransport.runtime.dagger.Module
import dagger.hilt.android.AndroidEntryPoint

@Module
class On_BoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentOnBoardingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=OnBoardingAdapter(){
            findNavController().navigateUp()
        }

        binding.onBoarding.adapter=adapter

        val pagerSnapHelper=PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.onBoarding)

        binding.indicator.attachToRecyclerView(binding.onBoarding,pagerSnapHelper)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }
}