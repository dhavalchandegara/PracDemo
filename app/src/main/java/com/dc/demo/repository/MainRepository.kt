package com.dc.demo.repository

import com.dc.demo.data.remote.APIServices

class MainRepository(private val apiServices: APIServices) {

    suspend fun getTopData() = apiServices.getTopRepo()

    suspend fun getMiddleData() = apiServices.getMiddleRepo()

    suspend fun getBottomData() = apiServices.getBottomRepo()

    suspend fun getCategory() = apiServices.getCategory()

}