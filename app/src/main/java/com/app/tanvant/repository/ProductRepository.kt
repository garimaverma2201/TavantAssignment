package com.app.tanvant.repository

import com.app.tanvant.api.ApiService
import javax.inject.Inject

class ProductRepository
@Inject constructor(private val apiService: ApiService)
{
    suspend fun getProductList() = apiService.getFakeProductList()
}