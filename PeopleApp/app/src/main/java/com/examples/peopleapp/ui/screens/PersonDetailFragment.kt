package com.examples.peopleapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.examples.peopleapp.R
import com.examples.peopleapp.databinding.FragmentPersonDetailBinding

class PersonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPersonDetailBinding.inflate(inflater,container,false)

        val bundle: PersonDetailFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.editTextPersonName.setText(gelenKisi.kisi_ad)
        binding.editTextPersonTel.setText(gelenKisi.kisi_tel)

        binding.buttonUpdate.setOnClickListener {
            val kisi_adi = binding.editTextPersonName.text.toString()
            val kisi_tel = binding.editTextPersonTel.text.toString()
            update(gelenKisi.kisi_id,kisi_adi,kisi_tel)
        }

        return binding.root
    }

    fun update(kisi_id:Int,kisi_ad: String,kisi_tel: String) {
        Log.e("Kisi güncelle","${kisi_id}->${kisi_ad}->${kisi_tel}")
    }
}