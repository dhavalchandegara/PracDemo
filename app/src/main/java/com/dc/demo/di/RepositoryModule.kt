package com.dc.demo.di

import com.dc.demo.data.remote.APIServices
import com.dc.demo.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun getMainRepository(apiServices: APIServices): MainRepository {
        return MainRepository(apiServices)
    }
}