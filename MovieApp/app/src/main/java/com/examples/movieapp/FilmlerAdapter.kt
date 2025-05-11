package com.examples.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.examples.movieapp.databinding.CardTasarimBinding
import com.examples.movieapp.databinding.FragmentAnaSayfaBinding
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext: Context,var filmlerListesi: List<Filmler>) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        var binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarim
        t.textViewFiyat.text = "${film.fiyat}₺"
        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName)
        )
        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} sepete eklendi", Snackbar.LENGTH_SHORT).show()
        }

        t.cardViewFilm.setOnClickListener {
            val gecis = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToDetayFragment(filmNesnesi = film)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

}

