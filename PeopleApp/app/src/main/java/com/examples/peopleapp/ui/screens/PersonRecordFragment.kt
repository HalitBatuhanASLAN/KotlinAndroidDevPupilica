package com.examples.peopleapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.examples.peopleapp.R
import com.examples.peopleapp.databinding.FragmentPersonRecordBinding

class PersonRecordFragment : Fragment() {
    private lateinit var binding: FragmentPersonRecordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPersonRecordBinding.inflate(inflater,container,false)

        binding.buttonRecord.setOnClickListener {
            val person_name = binding.editTextPersonName.text.toString()
            val person_tel_number = binding.editTextPersonTel.text.toString()
            record(person_name,person_tel_number)
        }

        return binding.root
    }

    fun record(name : String,tel_number: String){
        Log.e("Person added","${name}->${tel_number}")
    }
}