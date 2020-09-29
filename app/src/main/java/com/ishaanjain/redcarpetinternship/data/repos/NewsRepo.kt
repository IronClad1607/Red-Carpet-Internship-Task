package com.ishaanjain.redcarpetinternship.data.repos

import com.ishaanjain.redcarpetinternship.data.api.RetrofitClient

object NewsRepo {
    suspend fun getHeadlinesIndia(page: Int, apiKey: String) =
        RetrofitClient.apiCall.getHeadlinesIndia(page, apiKey)
}