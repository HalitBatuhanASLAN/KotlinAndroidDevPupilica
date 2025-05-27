package com.examples.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examples.finalproject.data.entity.Products
import com.examples.finalproject.data.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewmodel @Inject constructor(var productRepository: ProductRepository) : ViewModel() {

    var productList = MutableLiveData<List<Products>>()

    init {
        uploadProduct()
    }

    fun uploadProduct(){
        CoroutineScope(Dispatchers.Main).launch {
            productList.value = productRepository.uploadProduct()
        }
    }

    fun search(searchWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                productList.value = productRepository.search(searchWord)
            }catch (e: Exception){ }
        }
    }


}