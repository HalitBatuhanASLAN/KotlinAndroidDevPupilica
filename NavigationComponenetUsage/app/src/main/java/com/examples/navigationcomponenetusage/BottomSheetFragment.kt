package com.examples.navigationcomponenetusage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.examples.navigationcomponenetusage.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBottomSheetBinding.inflate(inflater,container,false)

        binding.imageViewTest.setOnClickListener {
            //alt taraf bulunduğu aktivite demek
            Toast.makeText(requireContext(),"Cliclked on picture", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}