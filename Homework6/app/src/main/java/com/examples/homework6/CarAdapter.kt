package com.examples.homework6

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.examples.homework6.databinding.CardDesignBinding

class CarAdapter(var mContext: Context,var carList: List<Cars>): RecyclerView.Adapter<CarAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var design: CardDesignBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        var binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }


    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val car = carList.get(position)
        val t = holder.design
        t.tvCarName.text = "${car.brand} ${car.model}"
        t.tvCity.text = "${car.city}"
        t.tvPrice.text = "${car.price}"
        t.ivCar.setImageResource(
            mContext.resources.getIdentifier(car.picture,"drawable",mContext.packageName)
        )

        t.carViewCar.setOnClickListener{
            val passing = MainPageFragmentDirections.toDetail(carObject = car)
            Navigation.findNavController(it).navigate(passing)
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}