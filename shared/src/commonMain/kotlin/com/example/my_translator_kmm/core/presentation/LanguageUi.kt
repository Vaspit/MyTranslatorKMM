package com.example.my_translator_kmm.core.presentation

import com.example.my_translator_kmm.core.domain.language.Language

expect class LanguageUi {
    val language: Language

    companion object {
        val allLanguages: List<LanguageUi>
        fun byCode(languageCode: String): LanguageUi
    }
}