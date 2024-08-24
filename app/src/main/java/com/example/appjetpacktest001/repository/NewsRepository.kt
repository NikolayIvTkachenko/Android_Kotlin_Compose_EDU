package com.example.appjetpacktest001.repository

import com.example.appjetpacktest001.dao.NewsDao
import com.example.appjetpacktest001.models.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class NewsRepository(private val dao: NewsDao) {
    private val _newsFeed = MutableSharedFlow<News>()
    val newsFeed = _newsFeed.asSharedFlow()

    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    init {
        scope.launch {
            while (true) {
                val news = dao.fetchNewsFromApi()
                news.forEach{ _newsFeed.emit(it)}

                delay(3000)
            }
        }
    }

    fun stop() = scope.cancel()
}