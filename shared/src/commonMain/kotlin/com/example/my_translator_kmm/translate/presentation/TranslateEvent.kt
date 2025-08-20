package com.example.my_translator_kmm.translate.presentation

import com.example.my_translator_kmm.core.presentation.LanguageUi
import com.example.my_translator_kmm.translate.presentation.history.model.HistoryItemUi

sealed class TranslateEvent {

    data class OnChooseFromLanguageClick(val language: LanguageUi) : TranslateEvent()

    data class OnChooseToLanguageClick(val language: LanguageUi) : TranslateEvent()

    data class OnChangeTranslationText(val text: String) : TranslateEvent()

    data class OnHistoryItemSelected(val item: HistoryItemUi) : TranslateEvent()

    data class OnSubmitVoiceResult(val result: String?) : TranslateEvent()

    data object OnErrorSeen : TranslateEvent()

    data object OnHideLanguageChooser : TranslateEvent()

    data object OnSwapClick : TranslateEvent()

    data object OnTranslateClick : TranslateEvent()

    data object OnFromLanguageDropDownClick : TranslateEvent()

    data object OnToLanguageDropDownClick : TranslateEvent()

    data object OnCloseTranslationClick : TranslateEvent()

    data object OnEditTranslationClick: TranslateEvent()

    data object OnRecordAudioClick : TranslateEvent()
}
