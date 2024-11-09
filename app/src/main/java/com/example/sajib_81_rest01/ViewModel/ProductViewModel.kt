package com.example.sajib_81_rest01.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sajib_81_rest01.ApiInterface.apiService
import com.example.sajib_81_rest01.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _product = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>> get() = _product

    init {
        viewModelScope.launch {
            fetchProducts()
        }
    }

    private suspend fun fetchProducts() {
        try {
            val response = apiService.getProducts()
            _product.postValue(response)
        } catch (e: Exception) {

        }
    }
}