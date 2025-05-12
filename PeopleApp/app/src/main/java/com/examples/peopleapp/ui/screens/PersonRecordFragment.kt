package com.examples.peopleapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.examples.peopleapp.R
import com.examples.peopleapp.databinding.FragmentPersonRecordBinding
import com.examples.peopleapp.ui.viewModel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class PersonRecordFragment : Fragment() {
    private lateinit var binding: FragmentPersonRecordBinding
    private lateinit var viewModel: KisiKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPersonRecordBinding.inflate(inflater,container,false)

        binding.buttonRecord.setOnClickListener {
            val person_name = binding.editTextPersonName.text.toString()
            val person_tel_number = binding.editTextPersonTel.text.toString()
            viewModel.record(person_name,person_tel_number)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

}