package com.example.my_translator_kmm.translate.data.history.mappers

import com.example.my_translator_kmm.translate.domain.history.model.HistoryItem
import database.HistoryEntity

fun HistoryEntity.toDomain() = HistoryItem(
    id = id,
    fromLanguageCode = fromLanguageCode,
    fromText = fromText,
    toLanguageCode = toLanguageCode,
    toText = toText
)
