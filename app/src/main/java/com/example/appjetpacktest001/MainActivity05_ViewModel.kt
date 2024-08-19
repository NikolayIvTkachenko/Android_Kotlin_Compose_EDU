package com.example.appjetpacktest001

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appjetpacktest001.ui.theme.AppJetPackTest001Theme
import com.example.appjetpacktest001.viewmodels.SampleViewModel

class MainActivity05_ViewModel : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: SampleViewModel = SampleViewModel()

        setContent {
            AppJetPackTest001Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopLevel(model = model)
                }
            }
        }
    }
}

@Composable
fun TopLevel(model: SampleViewModel) {
    Log.d("TNI_001", "TopLevel")
    val customerName: String by model.customerName.observeAsState("")
    MainScreenViewModel01(count = model.customerCount) {model.increaseCount()}
}

@Composable
fun MainScreenViewModel01(count: Int, addCount: () -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Total customers = $count",
            modifier = Modifier.padding(10.dp)
        )
        Button(onClick = addCount) {
            Text(text = "Add a Customer")
        }
    }
}