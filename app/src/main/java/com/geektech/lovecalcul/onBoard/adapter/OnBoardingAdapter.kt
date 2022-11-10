package com.geektech.lovecalcul.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.geektech.lovecalcul.R
import com.geektech.lovecalcul.databinding.ItemOnBoardingBinding
import com.geektech.lovecalcul.onBoard.OnBoard

class OnBoardingAdapter(private val onClick:()->Unit):RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val arrayListBoarding = arrayListOf<OnBoard>()

    init {
        arrayListBoarding.add(
            OnBoard(
                R.raw.lotti,
                "    ",
                "    "
            )
        )
        arrayListBoarding.add(
            OnBoard(
                R.raw.lotti,
                "      ",
                "      "
            )
        )
        arrayListBoarding.add(
            OnBoard(
                R.raw.lotti,
                "      ",
                "     "
            )
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(
            LayoutInflater.from(parent.context),
                    parent, false
        )
        )

    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayListBoarding[position])
    }

    override fun getItemCount(): Int =arrayListBoarding.size


    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard:OnBoard) {
            binding.skip.setOnClickListener{onClick()}
            binding.bntStart.setOnClickListener{onClick()}
            binding.skip.isVisible = adapterPosition != arrayListBoarding.size - 1
            binding.bntStart.isVisible = adapterPosition == arrayListBoarding.size
            binding.tvTitle.text=onBoard.title
            binding.tvDesc.text=onBoard.description
            onBoard.image?.let { binding.animationView.setAnimation(it) }
        }
    }

}