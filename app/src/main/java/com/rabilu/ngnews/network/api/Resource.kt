package com.rabilu.ngnews.network.api

sealed class Resource<T>(
    val data: T? = null,
    val errorMessage: String? = null,
) {
    class Success<T>(data: T? = null) : Resource<T>(data = data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(data: T? = null, errorMessage: String?) : Resource<T>(data, errorMessage)
}
