package com.dc.demo.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T?, message: String? = "") : Resource<T>(data = data, message = message)
    class Failed<T>(data: T? = null, message: String?) : Resource<T>(data = data, message = message)
}