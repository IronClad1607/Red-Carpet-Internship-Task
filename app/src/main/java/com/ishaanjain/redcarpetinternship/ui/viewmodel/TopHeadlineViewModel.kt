package com.ishaanjain.redcarpetinternship.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ishaanjain.redcarpetinternship.data.models.Article
import com.ishaanjain.redcarpetinternship.data.repos.NewsRepo
import com.ishaanjain.redcarpetinternship.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopHeadlineViewModel : ViewModel() {
    val indiaHeadlines = MutableLiveData<List<Article>>()
    val usaHeadlines = MutableLiveData<List<Article>>()
    val ukHeadlines = MutableLiveData<List<Article>>()

    fun fetchIndiaHeadline() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.IO) {
                NewsRepo.getHeadlinesIndia(Constants.apiKey)
            }

            if (response.isSuccessful) {
                response.body()?.let {
                    indiaHeadlines.postValue(it.articles)
                }
            }
        }
    }

    fun fetchUsaHeadline() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.IO) {
                NewsRepo.getHeadlineUsa(Constants.apiKey)
            }

            if (response.isSuccessful) {
                response.body()?.let {
                    usaHeadlines.postValue(it.articles)
                }
            }
        }
    }

    fun fetchUkHeadline() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.IO) {
                NewsRepo.getHeadlineUk(Constants.apiKey)
            }

            if (response.isSuccessful) {
                response.body()?.let {
                    ukHeadlines.postValue(it.articles)
                }
            }
        }
    }
}