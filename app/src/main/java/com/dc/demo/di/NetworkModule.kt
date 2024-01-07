package com.dc.demo.di

import com.dc.demo.BuildConfig
import com.dc.demo.data.remote.APIServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun getHttpClient(): OkHttpClient {
        val timeOut = 1L
        val readTimeOut = 5L
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(timeOut, TimeUnit.MINUTES)
        builder.writeTimeout(timeOut, TimeUnit.MINUTES)
        builder.readTimeout(readTimeOut, TimeUnit.MINUTES)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        return builder.build()
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getAPIServices(retroFit: Retrofit): APIServices {
        return retroFit.create(APIServices::class.java)
    }
}