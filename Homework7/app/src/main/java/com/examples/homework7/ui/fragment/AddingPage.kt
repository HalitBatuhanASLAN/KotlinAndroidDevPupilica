package com.examples.homework7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.examples.homework7.databinding.FragmentAddingPageBinding
import com.examples.homework7.ui.viewModel.AddingPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddingPage : Fragment() {
    private lateinit var binding: FragmentAddingPageBinding
    private lateinit var viewModel: AddingPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddingPageBinding.inflate(inflater,container,false)

        binding.buttonAdding.setOnClickListener {
            val toDo = binding.editTextAdding.text.toString()
            viewModel.add(toDo)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddingPageViewModel by viewModels()
        viewModel = tempViewModel
    }
}