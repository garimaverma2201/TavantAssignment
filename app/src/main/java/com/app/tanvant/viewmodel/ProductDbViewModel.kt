package com.app.tanvant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.app.tanvant.model.ProductResponse
import com.app.tanvant.repository.ProductDbRepository
import com.app.tanvant.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDbViewModel
@Inject constructor(private val productRepository: ProductDbRepository) : ViewModel() {

    fun insertProduct(product: ProductResponse) = viewModelScope.launch {
        productRepository.insertProduct(product)
    }

    fun deleteProduct(product: ProductResponse) = viewModelScope.launch {
        productRepository.deleteProduct(product)
    }

    val allProductList = productRepository.getAllProduct().asLiveData()

}