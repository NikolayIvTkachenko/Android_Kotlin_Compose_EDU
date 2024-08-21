package com.example.appjetpacktest001.viewmodels


import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appjetpacktest001.db.ProductRoomDatabase
import com.example.appjetpacktest001.models.Product
import com.example.appjetpacktest001.repository.ProductRepository

class MainViewModel(application: Application) : ViewModel() {

    val allProducts: LiveData<List<Product>>
    private val repository: ProductRepository
    val searchResults: MutableLiveData<List<Product>>

    init {
        val productDb = ProductRoomDatabase.getInstance(application)
        val productDao = productDb.productDao()
        repository = ProductRepository(productDao)

        allProducts = repository.allProducts
        searchResults = repository.searchResults
    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }

    fun findProduct(name: String) {
        repository.findProduct(name)
    }

    fun deleteProduct(name: String) {
        repository.deleteProduct(name)
    }

}