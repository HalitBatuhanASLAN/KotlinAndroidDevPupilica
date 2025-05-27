package com.examples.finalproject.data.repo

import com.examples.finalproject.data.datasource.ProductDataSource
import com.examples.finalproject.data.entity.Products

class ProductRepository(var productDataSource: ProductDataSource) {

    suspend fun uploadProduct() : List<Products> = productDataSource.uploadProduct()

    suspend fun search(searchWord:String) : List<Products> = productDataSource.search(searchWord)


}