package com.example.my_translator_kmm.core.domain.util

sealed class Resource<T>(
    val data: T?,
    val throwable: Throwable? = null
) {

    class Success<T>(data: T): Resource<T>(data)

    class Error<Nothing>(throwable: Throwable): Resource<Nothing>(null, throwable)
}
