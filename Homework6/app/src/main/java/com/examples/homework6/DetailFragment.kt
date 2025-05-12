package com.examples.homework6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.examples.homework6.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = FragmentDetailBinding.inflate(inflater,container,false)

         val bundle: DetailFragmentArgs by navArgs()
         val car = bundle.carObject;

         binding.tvPriceDetail.text = car.price.toString()
         binding.tvAnnouncementDate.text = car.announcementDate
         binding.tvBrand.text = car.brand
         binding.tvCarModel.text = car.model
         binding.tvGearType.text = car.gearType
         binding.tvYear.text = car.year
         binding.tvCityDetail.text = car.city
         binding.tvExchange.text = car.exchange
         binding.tvKilometers.text = car.kilometers

         var pList = car.pitureList

         val photoAdapter = DetailPhotoAdapter(requireContext(), pList)
         binding.rvDetailPhotos.adapter = photoAdapter
         binding.rvDetailPhotos.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

         return binding.root
    }

}