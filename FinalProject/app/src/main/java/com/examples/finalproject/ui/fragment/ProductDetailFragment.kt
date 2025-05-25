package com.examples.finalproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.examples.finalproject.R
import com.examples.finalproject.databinding.FragmentProductDetailBinding
import com.examples.finalproject.ui.viewmodel.ProductDetailViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var viewmodel: ProductDetailViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(layoutInflater,container,false)

        val bundle : ProductDetailFragmentArgs by navArgs()
        val currentProduct = bundle.product

        binding.tvFoodName.setText(currentProduct.yemek_adi)
        binding.tvFoodPrice.setText(currentProduct.yemek_fiyat.toString())

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${currentProduct.yemek_resim_adi}"
        Glide.with(this).load(url).override(300,300).into(binding.foodIv)



        return binding.root
    }
}