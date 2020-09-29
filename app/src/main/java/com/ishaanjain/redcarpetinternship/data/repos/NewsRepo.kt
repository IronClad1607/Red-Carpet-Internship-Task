package com.ishaanjain.redcarpetinternship.data.repos

import com.ishaanjain.redcarpetinternship.data.api.RetrofitClient

object NewsRepo {
    suspend fun getHeadlinesIndia(apiKey: String) =
        RetrofitClient.apiCall.getHeadlinesIndia(apiKey)

    suspend fun getHeadlineUsa(apiKey: String) = RetrofitClient.apiCall.getHeadlinesUsa(apiKey)

    suspend fun getHeadlineUk(apiKey: String) = RetrofitClient.apiCall.getHeadlinesUk(apiKey)

    suspend fun getSources(apiKey: String) = RetrofitClient.apiCall.getSources(apiKey)

    suspend fun findNews(keyword: String, apiKey: String) =
        RetrofitClient.apiCall.findNews(keyword, apiKey)
}