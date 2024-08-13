package com.example.appjetpacktest001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appjetpacktest001.ui.theme.AppJetPackTest001Theme

class MainActivity : ComponentActivity() {

    var highOrderFunctionExample = HighOrderFunctionExample()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppJetPackTest001Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //DemoText(message = "Welcome to Android", fontSize = 12f)

                    DemoScreen()
                    highOrderFunctionExample.main01()

                }
            }
        }
    }
}

@Composable
fun DemoText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}


@Composable
fun DemoSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..40f,
        value = sliderPosition,
        onValueChange = { onPositionChange(it) }
    )
}

@Composable
fun DemoScreen(){
    var slidePosition by remember { mutableStateOf(20f) }

    val handlePositionChange = { position: Float ->
        slidePosition = position
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DemoText(message = "Welcome to Compose", fontSize = slidePosition)
        Spacer(modifier = Modifier.height(150.dp))
        DemoSlider(sliderPosition = slidePosition, onPositionChange = handlePositionChange)
        Text(
            style = MaterialTheme.typography.bodyLarge,
            text = slidePosition.toInt().toString() + "sp"
        )
    }


}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AppJetPackTest001Theme {
//        DemoText(message = "Welcome to Android", fontSize = 12f)
//    }
//}

//===================================================OLD CODE

//Greeting("Android")
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AppJetPackTest001Theme {
//        Greeting("Android")
//    }
//}