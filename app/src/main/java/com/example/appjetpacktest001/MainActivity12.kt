package com.example.appjetpacktest001

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appjetpacktest001.dao.NewsDao
import com.example.appjetpacktest001.models.News
import com.example.appjetpacktest001.repository.NewsRepository
import com.example.appjetpacktest001.service.ServiceStatus
import com.example.appjetpacktest001.ui.theme.AppJetPackTest001Theme
import com.example.appjetpacktest001.viewmodels.DownloadViewModel
import com.example.appjetpacktest001.viewmodels.NewsViewModel

class MainActivity12 : ComponentActivity() {

    private val viewModel: DownloadViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.downloadServiceStatus.observe(this) {
            it?.also {
                onDownloadServiceStatus(it)
            }
        }

        val dao = object : NewsDao {
            private var index = 0
            override suspend fun fetchNewsFromApi(): List<News> {
                return listOf(
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),
                    News("News Content = ${++index} "),

                    )
            }
        }

        val newsRepository = NewsRepository(dao)
        val newsViewModel =  NewsViewModel(newsRepository)

        newsViewModel.newsLiveData.observe(this) {list ->
            list.onEach {
                Log.d("FLOW_TEST", "News -> ${it}")
            }


        }

        setContent {
            AppJetPackTest001Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenViewModel001()
                }
            }
        }
    }
}
//ViewModels
//https://dev.to/vtsen/recommended-ways-to-create-viewmodel-or-androidviewmodel-5e7k

private fun onDownloadServiceStatus(
    status: ServiceStatus
): Int = when (status) {
    ServiceStatus.Started -> {
        Log.d("FLOW_TEST", "ServiceStatus.Started ->  ")
    }

    ServiceStatus.Stopped -> {
        Log.d("FLOW_TEST", "ServiceStatus.Stopped -> ")
    }

    is ServiceStatus.Downloading -> {
        Log.d("FLOW_TEST", "ServiceStatus.Downloading -> ")
    }

    else -> {
        Log.d("FLOW_TEST", "else -> ")
    }
}


@Composable
fun MainScreenViewModel001() {
    Log.d("FLOW_TEST", "MainScreenViewModel001()")

}