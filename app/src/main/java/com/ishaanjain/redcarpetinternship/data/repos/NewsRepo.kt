package com.ishaanjain.redcarpetinternship.data.repos

import com.ishaanjain.redcarpetinternship.data.api.RetrofitClient

object NewsRepo {
    suspend fun getHeadlinesIndia(apiKey: String) =
        RetrofitClient.apiCall.getHeadlinesIndia(apiKey)

    suspend fun getSources(apiKey: String) = RetrofitClient.apiCall.getSources(apiKey)
}