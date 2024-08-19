package com.example.appjetpacktest001.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData

class SampleViewModel {

    var customerName: MutableLiveData<String> = MutableLiveData("")

    var customerCount by mutableIntStateOf(0)

    fun increaseCount() {
        Log.d("TNI_001", "SampleViewModel increaseCount()")
        customerCount++
        Log.d("TNI_001", "customerCount = $customerCount")
    }

    fun setName(name: String) {
        customerName.value = name
    }

}