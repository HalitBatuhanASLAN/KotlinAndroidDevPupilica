package com.examples.peopleapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.examples.peopleapp.R
import com.examples.peopleapp.data.entity.Kisiler
import com.examples.peopleapp.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainPageBinding.inflate(inflater,container,false)

        binding.fabButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.peopleToRecordPassing)
        }

        binding.buttonDetail.setOnClickListener {
            val kisi = Kisiler(1,"Ahmet","1111")
            //alt tarafta soldaki etiket sağdaki ise bizim üst satırdaki nesnemiz
            val gecis = MainPageFragmentDirections.peopleToDetailPassing(kisi = kisi)
            //Navigation.findNavController(it).navigate(R.id.peopleToDetailPassing)

            Navigation.findNavController(it).navigate(gecis)
        }
        return binding.root
    }

}