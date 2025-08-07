package com.example.my_translator_kmm.translate.data.translate

import com.example.my_translator_kmm.translate.domain.translate.TranslateError
import com.example.my_translator_kmm.translate.domain.translate.TranslateException
import io.ktor.client.statement.HttpResponse

fun handleError(httpResponse: HttpResponse) {
    when(httpResponse.status.value) {
        in 200..299 -> Unit

        500 -> throw TranslateException(TranslateError.SERVER_ERROR)

        in 400..499 -> throw TranslateException(TranslateError.CLIENT_ERROR)

        else -> throw TranslateException(TranslateError.UNKNOWN_ERROR)
    }
}
