package com.ishaanjain.redcarpetinternship.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ishaanjain.redcarpetinternship.data.models.Article
import com.ishaanjain.redcarpetinternship.data.repos.NewsRepo
import com.ishaanjain.redcarpetinternship.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {
    fun searchNews(keyword: String) = liveData(Dispatchers.IO) {
        val response = withContext(Dispatchers.IO) {
            NewsRepo.findNews(keyword, Constants.apiKey)
        }

        if (response.isSuccessful) {
            response.body()?.let {
                emit(it)
            }
        }
    }
}