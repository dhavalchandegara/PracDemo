package com.dc.demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dc.demo.common.Resource
import com.dc.demo.models.Data
import com.dc.demo.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    fun getHomePageData() = liveData(Dispatchers.IO) {
        try {
            emit(Resource.Loading())

            coroutineScope {
                val data = ArrayList<Data>()

                val tasks = ArrayList<Deferred<Any>>()
                val async1 = async {
                    val topData = mainRepository.getTopData()
                    data.add(Data(data = topData.mainStickyMenu))
                    return@async topData
                }
                tasks.add(async1)

                val async2 = async {
                    val middle = mainRepository.getMiddleData()
                    data.add(Data(data = middle.shopByCategory))
                    data.add(Data(data = middle.shopByFabric))
                    data.add(Data(data = middle.unstitched))
                    data.add(Data(data = middle.boutiqueCollection))
                    middle
                }
                tasks.add(async2)

                val async3 = async {
                    val bottom = mainRepository.getBottomData()
                    data.add(Data(data = bottom.rangeOfPattern))
                    data.add(Data(data = bottom.designOccasion))
                    bottom
                }
                tasks.add(async3)

                tasks.awaitAll()

                emit(Resource.Success(data))
            }

        } catch (e: Exception) {
            when (e) {
                is IOException -> {
                    emit(Resource.Failed(message = "No Internet Available."))
                }

                is HttpException -> {
                    emit(Resource.Failed(message = "Failed To Get Data."))
                }

                else -> {
                    emit(Resource.Failed(message = "Oops, Something Went Wrong!"))
                }
            }
        }
    }

    fun getCategory() = liveData(Dispatchers.IO) {
        try {
            emit(Resource.Loading())

            emit(Resource.Success(mainRepository.getCategory()))

        } catch (e: Exception) {
            when (e) {
                is IOException -> {
                    emit(Resource.Failed(message = "No Internet Available."))
                }

                is HttpException -> {
                    emit(Resource.Failed(message = "Failed To Get Data."))
                }

                else -> {
                    emit(Resource.Failed(message = "Oops, Something Went Wrong!"))
                }
            }
        }
    }
}