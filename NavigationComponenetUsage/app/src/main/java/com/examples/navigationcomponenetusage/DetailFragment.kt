package com.examples.navigationcomponenetusage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.examples.navigationcomponenetusage.databinding.FragmentDetailBinding
import java.util.Objects

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        //veri okuma sınıfının sonuna args eki gelir
        //veri gönderme yapısı
        val bundle: DetailFragmentArgs by navArgs()
        val takingMessage = bundle.mesage
        val takingNumber = bundle.number

        binding.textViewResult.text = "${takingMessage} - ${takingNumber}"

        //OnBack kısmını object ata onu da reverseButton ata
        val reverseButton = object: OnBackPressedCallback(false){//true geri dönüş aktif değil
            override fun handleOnBackPressed() {
                Log.e("Detail page","reverse button worked")
                isEnabled = false//artık geri tuşu aktif
            }
        }

        //geri tuşuna basılınca yapılacakları belirtmiş oluruz
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,reverseButton)

        // Inflate the layout for this fragment
        return binding.root
    }
}