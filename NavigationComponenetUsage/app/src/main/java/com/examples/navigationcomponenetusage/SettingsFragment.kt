package com.examples.navigationcomponenetusage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.examples.navigationcomponenetusage.databinding.FragmentDetailBinding
import com.examples.navigationcomponenetusage.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater,container,false)

        binding.buttonShow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.bottomSheetPassing)
        }
        return binding.root
    }
}
