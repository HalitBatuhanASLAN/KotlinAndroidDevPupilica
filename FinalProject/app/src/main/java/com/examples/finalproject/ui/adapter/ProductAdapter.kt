package com.examples.finalproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.examples.finalproject.data.entity.Products
import com.examples.finalproject.databinding.CardDesignBinding
import com.examples.finalproject.ui.fragment.MainPageFragmentDirections
import com.examples.finalproject.ui.viewmodel.MainPageViewmodel
import com.examples.finalproject.utils.passing

class ProductAdapter(var mContext: Context,
                     var productsList: List<Products>,
                     var viewModel: MainPageViewmodel)
    : RecyclerView.Adapter<ProductAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardDesignBinding): RecyclerView.ViewHolder(design.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val product = productsList.get(position)
        val t = holder.design
        t.nameProduct.text = product.yemek_adi
        t.price.text = product.yemek_fiyat.toString()
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${product.yemek_resim_adi}"

        Glide.with(mContext).load(url).override(300).into(t.productPhoto)

        t.cardViewProduct.setOnClickListener {
            val passing = MainPageFragmentDirections.actionMainPageFragmentToProductDetailFragment(product)
            Navigation.passing(it,passing)
        }
    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}