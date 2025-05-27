package com.examples.finalproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.examples.finalproject.R
import com.examples.finalproject.data.entity.ProChart
import com.examples.finalproject.databinding.FragmentProductDetailBinding
import com.examples.finalproject.ui.viewmodel.ProductDetailViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val viewmodel: ProductDetailViewmodel by viewModels()

    private var orderCount = 0
    private var existingCartItem: ProChart? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: ProductDetailFragmentArgs by navArgs()
        val product = bundle.product

        binding.tvFoodName.text = product.yemek_adi
        binding.tvFoodPrice.text = "${product.yemek_fiyat} ₺"
        binding.totalTV.text = orderCount.toString()
        binding.tvTotalPrice.text = (orderCount * (product.yemek_fiyat)).toString()

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${product.yemek_resim_adi}"
        Glide.with(this).load(url).override(300, 300).into(binding.foodIv)

        viewmodel.checkProductInCart(product.yemek_adi, "HBA_1907")

        viewmodel.existingCartItem.observe(viewLifecycleOwner) { cartItem ->
            existingCartItem = cartItem

            if (cartItem != null) {
                orderCount = cartItem.yemek_siparis_adet
                binding.totalTV.text = orderCount.toString()
                binding.tvTotalPrice.text = (orderCount * (product.yemek_fiyat)).toString()
                binding.tvAddChart.text = "Sepeti Güncelle"

                Toast.makeText(requireContext(),
                    "Bu ürün sepetinizde mevcut (${cartItem.yemek_siparis_adet} adet)",
                    Toast.LENGTH_SHORT).show()
            } else {

                binding.tvAddChart.text = "Sepete Ekle"
            }
        }

        binding.floatingActionButton.setOnClickListener {
            orderCount++
            binding.totalTV.text = orderCount.toString()
            binding.tvTotalPrice.text = (orderCount * (product.yemek_fiyat)).toString()
        }

        binding.floatingActionButton2.setOnClickListener {
            if (orderCount > 0) {
                orderCount--
                binding.totalTV.text = orderCount.toString()
                binding.tvTotalPrice.text = (orderCount * (product.yemek_fiyat)).toString()
            }
        }

        binding.tvAddChart.setOnClickListener {
            if (orderCount > 0) {
                if (existingCartItem != null) {
                    viewmodel.updateCartItem(
                        sepet_yemek_id = existingCartItem!!.sepet_yemek_id,
                        yemek_adi = product.yemek_adi,
                        yemek_resim_adi = product.yemek_resim_adi,
                        yemek_fiyat = product.yemek_fiyat.toInt(),
                        yemek_siparis_adet = orderCount,
                        kullanici_adi = "HBA_1907"
                    )
                    Toast.makeText(requireContext(),
                        "Sepet güncellendi: $orderCount adet ${product.yemek_adi}",
                        Toast.LENGTH_SHORT).show()
                } else {

                    viewmodel.addChart(
                        yemek_adi = product.yemek_adi,
                        yemek_resim_adi = product.yemek_resim_adi,
                        yemek_fiyat = product.yemek_fiyat.toInt(),
                        yemek_siparis_adet = orderCount,
                        kullanici_adi = "HBA_1907"
                    )
                    Toast.makeText(requireContext(),
                        "$orderCount adet ${product.yemek_adi} sepete eklendi!",
                        Toast.LENGTH_SHORT).show()
                }

                findNavController().popBackStack()

            } else {
                Toast.makeText(requireContext(), "Lütfen adet seçiniz!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
