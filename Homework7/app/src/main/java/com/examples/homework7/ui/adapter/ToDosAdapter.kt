package com.examples.homework7.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.examples.homework7.data.entity.ToDos
import com.examples.homework7.databinding.CardTasarimBinding
import com.examples.homework7.ui.fragment.MainPageDirections
import com.examples.homework7.ui.viewModel.MainPageViewModel
import com.examples.homework7.utils.passing
import com.google.android.material.snackbar.Snackbar

class ToDosAdapter(var mContext:Context,
                   var toDosList: List<ToDos>,
                   var viewModel: MainPageViewModel
    ) : RecyclerView.Adapter<ToDosAdapter.CardDesingHolder>(){

    inner class CardDesingHolder(var design: CardTasarimBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesingHolder {
        val desingn = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesingHolder(desingn)
    }
    override fun onBindViewHolder(
        holder: CardDesingHolder,
        position: Int
    ) {
        val toDo = toDosList.get(position)//0,1,2
        val t = holder.design
        t.textViewKisiAd.text = toDo.toDo_name
        t.cardViewSatir.setOnClickListener {
            val gecis = MainPageDirections.detailPassing(toDo)
            Navigation.passing(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${toDo.toDo_name} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.delete(toDo.toDo_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return toDosList.size
    }


}