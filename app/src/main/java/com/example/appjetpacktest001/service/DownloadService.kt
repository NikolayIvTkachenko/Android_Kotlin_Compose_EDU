package com.example.appjetpacktest001.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class DownloadService: Service() {

    companion object {
        private val _downloadState = MutableStateFlow<ServiceStatus>(ServiceStatus.Stopped)
        val download = _downloadState.asStateFlow()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}