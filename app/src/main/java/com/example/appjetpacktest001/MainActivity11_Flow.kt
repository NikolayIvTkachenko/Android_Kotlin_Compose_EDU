package com.example.appjetpacktest001

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appjetpacktest001.models.TokenData
import com.example.appjetpacktest001.ui.theme.AppJetPackTest001Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity11_Flow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppJetPackTest001Theme  {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenFlow001()
                }
            }
        }
    }
}

//https://x-team.com/blog/kotlin-flow-android-app
//https://developer.android.com/kotlin/flow?hl=ru
//https://medium.com/android-beginners/creating-android-app-using-mvvm-coroutines-flow-hilt-a8acf7f57630
@Composable
fun MainScreenFlow001() {
    //println("TEST==========")
    Log.d("FLOW_TEST", "MainScreenFlow001()")

//    runBlocking {
//        val contentFlow = locationsFlow.map {
//
//        }
//    }


    runBlocking {
        //mainSample02()
        mainSample03()
    }

    runBlocking {
        val flow = numbers()
        flow.collect{
            println(it)
            Log.d("FLOW_TEST", "it = $it")
        }
    }


    runBlocking {
        val index = getDataFlow(5)
        Log.d("FLOW_TEST", "getDataFlow(5) = $index")
        index.collect{data ->
            Log.d("FLOW_TEST", "data = $data")
        }
    }

    runBlocking {
        val newFlow: Flow<String> = numbers().map {
            transform(it)
        }
    }

}

fun numbers(): Flow<Int> = flow {
    emit(1)
    emit(2)
}

private fun getDataFlow(n: Int): Flow<TokenData> {
    return flow {
        //connect()
        Log.d("FLOW_TEST", "connect()")
        repeat(n) {
            val token = "5544552221"
            val data = "sssddfrrtfff"
            emit(TokenData(token, data))
        }
    }.onCompletion {
        //disconnect()
        Log.d("FLOW_TEST", "disconnect()")
    }
}

//map, filter, debounce, buffer, onCompletion
suspend fun transform(i: Int): String = withContext(Dispatchers.Default) {
    delay(10)
    "${i + 1}"

}

suspend fun mainSample01(){
    val flow = (1..100).asFlow().onEach { delay(10) }
    val startTime = System.currentTimeMillis()
    flow.buffer(10).collect{
        val time = System.currentTimeMillis() - startTime
        Log.d("FLOW_TEST", "time = $time")
    }
}

val upstream = flowOf(1, 2, 3)
suspend fun mainSample02() {
    try {
        upstream.collect{ value ->
            if(value > 2) {
                throw RuntimeException()
            }
            Log.d("FLOW_TEST", "Received = $value")
        }
    }catch (e: Exception) {
        Log.d("FLOW_TEST", "Exception = $e")
    }
}


val upstreamV2 = flowOf(1, 2, 3)
    .onEach { value ->
        if(value > 2) throw RuntimeException()
    }

suspend fun mainSample03() {
    try {
        upstreamV2.collect {value ->
            Log.d("FLOW_TEST", "Received = $value")
        }
    } catch (e: Throwable) {
        Log.d("FLOW_TEST", "Exception = $e")
    }
}