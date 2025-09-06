package com.example.my_translator_kmm.core.presentation

import com.example.my_translator_kmm.core.domain.language.Language

actual class LanguageUi(
    val imageName: String,
    actual val language: Language,
) {
    actual companion object {
        actual val allLanguages: List<LanguageUi>
            get() = Language.entries.map { language ->
                LanguageUi(
                    language = language,
                    imageName = language.langName.lowercase()
                )
            }.sortedBy { it.language.langName }

        /**
         * @throws IllegalArgumentException
         */
        actual fun byCode(languageCode: String): LanguageUi {
            return allLanguages.find { it.language.langCode == languageCode }
                ?: throw IllegalArgumentException("Invalid or unsupported language code")
        }
    }
}
