package com.ishaanjain.redcarpetinternship.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ishaanjain.redcarpetinternship.data.models.Sources
import com.ishaanjain.redcarpetinternship.data.models.SourcesResponse
import com.ishaanjain.redcarpetinternship.data.repos.NewsRepo
import com.ishaanjain.redcarpetinternship.utils.Constants
import kotlinx.coroutines.*

class NewsViewModel : ViewModel() {
    var sources = MutableLiveData<List<Sources>>()

    fun fetchSources() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.IO) {
                NewsRepo.getSources(Constants.apiKey)
            }

            if (response.isSuccessful) {
                response.body()?.let {
                    sources.postValue(it.sources)
                }
            }
        }
    }
}