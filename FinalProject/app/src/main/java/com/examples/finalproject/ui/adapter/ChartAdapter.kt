package com.examples.finalproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.examples.finalproject.data.entity.ProChart
import com.examples.finalproject.data.entity.Products
import com.examples.finalproject.databinding.CardChartDesignBinding
import com.examples.finalproject.databinding.CardDesignBinding
import com.examples.finalproject.ui.viewmodel.MainPageViewmodel
import com.examples.finalproject.ui.viewmodel.ProductCartViewmodel
import com.google.android.material.snackbar.Snackbar

class ChartAdapter(var mContext: Context,
                   var chartList: List<ProChart>,
                   var viewModel: ProductCartViewmodel)
                        : RecyclerView.Adapter<ChartAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardChartDesignBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartAdapter.CardDesignHolder {
        val design = CardChartDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: ChartAdapter.CardDesignHolder, position: Int) {
        val chartProduct = chartList.get(position)
        val t = holder.design
        t.nameProduct.text = chartProduct.yemek_adi
        t.price.text = chartProduct.yemek_fiyat.toString()
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${chartProduct.yemek_resim_adi}"

        t.tvAdet.text = chartProduct.yemek_siparis_adet.toString()
        t.tvTotal.text = (chartProduct.yemek_fiyat*chartProduct.yemek_siparis_adet).toString()
        Glide.with(mContext).load(url).override(300).into(t.productPhoto)

        t.ivDelete.setOnClickListener { view->
            Snackbar.make(view, "${t.nameProduct.text.toString()} sepetten kaldırılsın mı?", Snackbar.LENGTH_LONG)
                .setAction("SİL") {
                    viewModel.deleteFromChart(chartProduct.sepet_yemek_id.toInt(), "HBA_1907")
                }
                .setActionTextColor(mContext.getColor(android.R.color.holo_red_light))
                .show()
        }
    }

    override fun getItemCount(): Int {
        return chartList.size
    }


}