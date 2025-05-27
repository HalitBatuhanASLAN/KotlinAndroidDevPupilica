package com.examples.homework7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.examples.homework7.R
import com.examples.homework7.databinding.FragmentMainPageBinding
import com.examples.homework7.ui.adapter.ToDosAdapter
import com.examples.homework7.ui.viewModel.MainPageViewModel
import com.examples.homework7.utils.passing
import kotlin.getValue

class MainPage : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater,container,false)

        binding.fab.setOnClickListener {
            Navigation.passing(it,R.id.passing_adding)
        }

        viewModel.toDosList.observe(viewLifecycleOwner){
            val toDoAdapter = ToDosAdapter(requireContext(),it,viewModel)
            binding.toDoRv.adapter = toDoAdapter
        }

        binding.toDoRv.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Ara buttonuna basılınca
                viewModel.search(query)
                return true
            }
        })




        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.upload()
    }
}