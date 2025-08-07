package com.example.my_translator_kmm.translate.domain.translate

import com.example.my_translator_kmm.core.domain.language.Language

interface TranslateClient {

    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}
