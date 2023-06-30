package com.app.tanvant.repository

import com.app.tanvant.db.ProductDao
import com.app.tanvant.model.ProductResponse
import javax.inject.Inject

class ProductDbRepository
@Inject constructor(private val productDao: ProductDao)
{
    suspend fun insertProduct(product:ProductResponse) = productDao.insertProduct(product)
    suspend fun deleteProduct(product: ProductResponse) = productDao.deleteProduct(product)
    fun getAllProduct() = productDao.getAllProduct()
}