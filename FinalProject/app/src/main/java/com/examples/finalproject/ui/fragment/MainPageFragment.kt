package com.examples.finalproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.appcompat.widget.SearchView

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.examples.finalproject.R
import com.examples.finalproject.databinding.FragmentMainPageBinding
import com.examples.finalproject.ui.adapter.ProductAdapter
import com.examples.finalproject.ui.viewmodel.MainPageViewmodel
import com.examples.finalproject.utils.passing
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewmodel: MainPageViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(layoutInflater,container,false)

        binding.fabChart.setOnClickListener {
            Navigation.passing(it,R.id.action_mainPageFragment_to_productCardFragment)
        }

        viewmodel.productList.observe(viewLifecycleOwner) {
            val productAdapter = ProductAdapter(requireContext(),it,viewmodel)
            binding.productsRv.adapter = productAdapter
        }

        binding.productsRv.layoutManager = LinearLayoutManager(requireContext())



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewmodel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewmodel.search(query)
                return true
            }
        })



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewmodel by viewModels()
        viewmodel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewmodel.uploadProduct()
    }
}