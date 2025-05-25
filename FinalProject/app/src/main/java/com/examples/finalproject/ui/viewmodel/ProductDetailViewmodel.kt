package com.examples.finalproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.examples.finalproject.data.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewmodel @Inject constructor(var productRepository: ProductRepository): ViewModel() {


}