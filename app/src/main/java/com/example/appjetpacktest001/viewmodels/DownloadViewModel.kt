package com.example.appjetpacktest001.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.appjetpacktest001.service.DownloadService

class DownloadViewModel : ViewModel() {
    val downloadServiceStatus = DownloadService.download.asLiveData()
}