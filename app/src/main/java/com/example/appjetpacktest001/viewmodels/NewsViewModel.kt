package com.example.appjetpacktest001.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appjetpacktest001.models.News
import com.example.appjetpacktest001.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository): ViewModel() {

    private val newsList = mutableListOf<News>()

    private val _newsLiveFata = MutableLiveData<List<News>>(newsList)
    val newsLiveData: LiveData<List<News>> = _newsLiveFata

    init {
        viewModelScope.launch {
            repository.newsFeed.collect{
                Log.d("FLOW_TEST", "NewsViewModel init repository.newsFeed.collect ->")
                newsList.add(it)
                _newsLiveFata.value = newsList
            }
        }
    }
}