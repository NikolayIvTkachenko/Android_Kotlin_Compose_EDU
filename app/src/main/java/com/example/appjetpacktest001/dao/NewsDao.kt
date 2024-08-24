package com.example.appjetpacktest001.dao

import com.example.appjetpacktest001.models.News

interface NewsDao {
    suspend fun fetchNewsFromApi(): List<News>
}