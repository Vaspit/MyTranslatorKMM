package com.example.my_translator_kmm.translate.presentation

import com.example.my_translator_kmm.core.presentation.LanguageUi
import com.example.my_translator_kmm.translate.domain.translate.TranslateError
import com.example.my_translator_kmm.translate.presentation.history.model.HistoryItemUi

data class TranslateState(
    val fromText: String = "",
    val toText: String? = null,
    val isTranslating: Boolean = false,
    val fromLanguage: LanguageUi = LanguageUi.byCode("en"),
    val toLanguage: LanguageUi = LanguageUi.byCode("de"),
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val error: TranslateError? = null,
    val history: List<HistoryItemUi> = emptyList()
)
