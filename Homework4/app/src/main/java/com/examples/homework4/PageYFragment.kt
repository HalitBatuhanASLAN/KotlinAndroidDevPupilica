package com.examples.homework4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.examples.homework4.databinding.FragmentPageYBinding

class PageYFragment : Fragment() {

    private lateinit var binding: FragmentPageYBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPageYBinding.inflate(inflater,container,false)

        var reverseButton = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                navigateToMainPage()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,reverseButton)

        return binding.root


    }

    private fun navigateToMainPage(){
        findNavController().navigate(R.id.mainPageFragment)
    }

}