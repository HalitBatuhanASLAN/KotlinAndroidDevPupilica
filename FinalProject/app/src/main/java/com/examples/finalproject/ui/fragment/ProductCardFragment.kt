package com.examples.finalproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.examples.finalproject.R
import com.examples.finalproject.databinding.FragmentProductCardBinding
import com.examples.finalproject.ui.adapter.ChartAdapter
import com.examples.finalproject.ui.viewmodel.ProductCartViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductCardFragment : Fragment() {
    private lateinit var binding: FragmentProductCardBinding
    private val viewmodel: ProductCartViewmodel by viewModels()
    private lateinit var chartAdapter: ChartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductCardBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()

        viewmodel.cartItems.observe(viewLifecycleOwner) {
            val chartAdapter = ChartAdapter(requireContext(),it,viewmodel)
            binding.rvChart.adapter = chartAdapter
        }

        viewmodel.getChartItems("HBA_1907")
    }

    private fun setupRecyclerView() {
        binding.rvChart.layoutManager = LinearLayoutManager(requireContext())

        chartAdapter = ChartAdapter(requireContext(), emptyList(), viewmodel)
        binding.rvChart.adapter = chartAdapter
    }

    private fun observeViewModel() {
        viewmodel.cartItems.observe(viewLifecycleOwner) { items ->
            chartAdapter = ChartAdapter(requireContext(), items, viewmodel)
            binding.rvChart.adapter = chartAdapter

            if (items.isEmpty()) {
                binding.emptyCartLayout.visibility = View.VISIBLE
                binding.bottomCartSection.visibility = View.GONE
            } else {
                binding.emptyCartLayout.visibility = View.GONE
                binding.bottomCartSection.visibility = View.VISIBLE
            }
        }

        viewmodel.totalItems.observe(viewLifecycleOwner) { count ->
            binding.tvTotalItems.text = "$count adet"
        }

        viewmodel.totalPrice.observe(viewLifecycleOwner) { price ->
            binding.tvTotalPrice.text = "₺${String.format("%.2f", price)}"
        }
    }

    override fun onResume() {
        super.onResume()
        setupRecyclerView()
    }
}