package com.examples.finalproject.data.datasource

import com.examples.finalproject.data.entity.Products
import com.examples.finalproject.retrofit.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductDataSource(var productDao: ProductDao) {

    suspend fun uploadProduct() : List<Products> = withContext(Dispatchers.IO){
        return@withContext productDao.uploadProduct().yemekler
    }

    suspend fun search(searchWord:String) : List<Products> = withContext(Dispatchers.IO) {
        return@withContext  productDao.search(searchWord).yemekler
    }
}