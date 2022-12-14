package com.geektech.lovecalcul

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalcul.databinding.FragmentLoveBinding
import com.geektech.lovecalcul.model.LoveApi
import com.geektech.lovecalcul.model.LoveModel
import com.google.android.datatransport.runtime.dagger.Module
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@AndroidEntryPoint
class LoveFragment  : Fragment() {
  @Inject
  lateinit var api:LoveApi
    lateinit var binding: FragmentLoveBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoveBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

    }
    private fun initClickers() {
        with(binding) {
            requestBtn.setOnClickListener {
                api.calculate(editFname.text.toString(), editSname.text.toString())
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>, response: Response<LoveModel>
                        ) {
                            val loveModel = response.body()
                           var bundle = Bundle()
                            bundle.putSerializable("key",loveModel)
                            findNavController().navigate(R.id.secondFragment,bundle)
                        }
                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                        }

                    })
            }
        }
    }
}