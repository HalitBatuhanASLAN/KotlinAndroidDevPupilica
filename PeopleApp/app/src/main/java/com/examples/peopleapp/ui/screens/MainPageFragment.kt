package com.examples.peopleapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.examples.peopleapp.R
import com.examples.peopleapp.data.entity.Kisiler
import com.examples.peopleapp.databinding.FragmentMainPageBinding
import com.examples.peopleapp.ui.adapter.KisilerAdapter
import com.examples.peopleapp.ui.viewModel.AnaSayfaViewModel
import com.examples.peopleapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel : AnaSayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainPageBinding.inflate(inflater,container,false)

        binding.fabButton.setOnClickListener {
            //Navigation.findNavController(it).navigate(R.id.peopleToRecordPassing)
            Navigation.gecisYap(it,R.id.peopleToRecordPassing)
        }

        //alt taraf dinleme kısmı
        viewModel.kisilerListesi.observe(viewLifecycleOwner) {
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerRv.adapter = kisilerAdapter
        }



        //alt taraf alta doğru
        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())

        //alt tarafta yatayda ayarladık
        //binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        //searchView kısmında andrid.widget kullanıyoruz
        binding.searchView2.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean{
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean{
                viewModel.ara(query)
                return true
            }
        })


        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnaSayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
        Log.e("Kisi anasayfa","Ana safaya dönüldü")
    }
}