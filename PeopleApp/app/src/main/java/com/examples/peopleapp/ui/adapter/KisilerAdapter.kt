package com.examples.peopleapp.ui.adapter

import android.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.examples.peopleapp.data.entity.Kisiler
import com.examples.peopleapp.databinding.CardTasarimBinding
import com.examples.peopleapp.databinding.FragmentMainPageBinding
import com.examples.peopleapp.ui.screens.MainPageFragment
import com.examples.peopleapp.ui.screens.MainPageFragmentDirections
import com.examples.peopleapp.ui.viewModel.AnaSayfaViewModel
import com.examples.peopleapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context,var kisilerListesi: List<Kisiler>,var viewModel: AnaSayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu,position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim
        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewSatir.setOnClickListener {
            val gecis = MainPageFragmentDirections.peopleToDetailPassing(kisi = kisi)
            //Navigation.findNavController(it).navigate(gecis)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ? ", Snackbar.LENGTH_SHORT)
                .setAction ( "Evet" ){
                    viewModel.sil(kisi.kisi_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }


}