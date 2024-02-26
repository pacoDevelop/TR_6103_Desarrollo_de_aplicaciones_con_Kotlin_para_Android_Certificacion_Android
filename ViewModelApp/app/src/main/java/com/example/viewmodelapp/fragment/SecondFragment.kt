package com.example.viewmodelapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.viewmodelapp.databinding.FragmentSecondBinding
import com.example.viewmodelapp.viewmodel.SecondViewModel
import com.example.viewmodelapp.viewmodel.factory.SecondViewModelFactory

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    private lateinit var viewModel: SecondViewModel

    private lateinit var viewModelFactory: SecondViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModelFactory =
            SecondViewModelFactory(SecondFragmentArgs.fromBundle(requireArguments()).clicks)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)

        viewModel.clicks.observe(
            viewLifecycleOwner,
            Observer { clicksNumber ->
                binding.secondFragmentTvClicks.text = clicksNumber.toString()
            })
        binding.secondFragmentBtClick.setOnClickListener { viewModel.addClicks() }
        binding.secondFragmentBtBack.setOnClickListener { backFragment() }
        return binding.root
    }

    private fun backFragment() {
        findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment22())
    }


}