package com.examples.homework7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.examples.homework7.R
import com.examples.homework7.databinding.FragmentDetailPageBinding
import com.examples.homework7.ui.viewModel.DetailPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class DetailPage : Fragment() {
    private lateinit var binding: FragmentDetailPageBinding
    private lateinit var viewModel: DetailPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPageBinding.inflate(inflater,container,false)

        val bundle : DetailPageArgs by navArgs()
        val current_toDo = bundle.argsDetail

        binding.editDetail.setText(current_toDo.toDo_name)

        binding.updateButton.setOnClickListener {
            val to_do_name = binding.editDetail.text.toString()
            viewModel.update(current_toDo.toDo_id,to_do_name)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailPageViewModel by viewModels()
        viewModel = tempViewModel
    }
}