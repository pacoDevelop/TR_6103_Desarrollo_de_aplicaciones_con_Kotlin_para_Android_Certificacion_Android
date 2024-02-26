package com.example.viewmodelapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.viewmodelapp.databinding.FragmentFirstBinding
import com.example.viewmodelapp.viewmodel.FirstViewModel

class FirstFragment : Fragment() {


    private lateinit var binding: FragmentFirstBinding

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        binding.firstViewModel = viewModel
        binding.lifecycleOwner = this

        //click listener
        binding.firstFragmentBtHello.setOnClickListener {
            viewModel.hello(binding.firstFragmentEtName.text.toString())
        }
        binding.firstFragmentBtGoodbye.setOnClickListener {
            viewModel.goodbye(binding.firstFragmentEtName.text.toString())
        }
        binding.firstFragmentBtEnd.setOnClickListener { nextFragment() }

        return binding.root
    }

    private fun nextFragment() {
        findNavController().navigate(
            FirstFragmentDirections.actionFirstFragment2ToSecondFragment(
                viewModel.clicks.value!!
            )
        )
    }


}