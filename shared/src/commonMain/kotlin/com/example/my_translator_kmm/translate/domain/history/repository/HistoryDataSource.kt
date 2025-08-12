package com.example.my_translator_kmm.translate.domain.history.repository

import com.example.my_translator_kmm.core.domain.util.CommonFlow
import com.example.my_translator_kmm.translate.domain.history.model.HistoryItem

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}
