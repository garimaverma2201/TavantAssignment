package com.app.tanvant.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.tanvant.model.ProductResponse
import com.app.tanvant.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject constructor(private val repository: ProductRepository) : ViewModel(){

    private val _response = MutableLiveData<List<ProductResponse>>()
    val productResponse: LiveData<List<ProductResponse>>
        get() = _response

    init {
        getProductResponseList()
    }

    private fun getProductResponseList() = viewModelScope.launch {

        repository.getProductList().let {
            if(!it.isEmpty()){
                Log.d("response success code", "get Recipe List: ${it}")
                _response.postValue(it)
            }else {
                Log.d("response error", "get Recipe: ${it}")
            }
        }
    }
}