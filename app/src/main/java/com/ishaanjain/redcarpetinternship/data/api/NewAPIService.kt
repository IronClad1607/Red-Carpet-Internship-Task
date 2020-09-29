package com.ishaanjain.redcarpetinternship.data.api

import com.ishaanjain.redcarpetinternship.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewAPIService {

    @GET("/top-headlines?country=in")
    suspend fun getHeadlinesIndia(
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>
}