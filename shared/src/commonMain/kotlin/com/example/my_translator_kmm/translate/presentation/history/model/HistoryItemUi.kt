package com.example.my_translator_kmm.translate.presentation.history.model

import com.example.my_translator_kmm.core.presentation.LanguageUi

data class HistoryItemUi(
    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: LanguageUi,
    val toLanguage: LanguageUi
)
