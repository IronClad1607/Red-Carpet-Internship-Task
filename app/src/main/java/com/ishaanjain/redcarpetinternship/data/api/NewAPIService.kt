package com.ishaanjain.redcarpetinternship.data.api

import com.ishaanjain.redcarpetinternship.data.models.NewsResponse
import com.ishaanjain.redcarpetinternship.data.models.SourcesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewAPIService {

    @GET("/v2/top-headlines?country=in")
    suspend fun getHeadlinesIndia(
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>

    @GET("/v2/sources?language=en")
    suspend fun getSources(@Query("apiKey") apiKey: String): Response<SourcesResponse>
}