package com.dc.demo.data.remote

import com.dc.demo.models.BottomResponse
import com.dc.demo.models.CategoryResponse
import com.dc.demo.models.MiddleResponse
import com.dc.demo.models.TopResponse
import retrofit2.http.GET

interface APIServices {

    @GET(Config.topData)
    suspend fun getTopRepo(): TopResponse

    @GET(Config.middleData)
    suspend fun getMiddleRepo(): MiddleResponse

    @GET(Config.bottomData)
    suspend fun getBottomRepo(): BottomResponse

    @GET(Config.category)
    suspend fun getCategory(): CategoryResponse
}