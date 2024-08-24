package com.example.appjetpacktest001.service

sealed class ServiceStatus {
    object Started : ServiceStatus()
    data class Downloading(val progress: Int): ServiceStatus()
    object Stopped: ServiceStatus()
}