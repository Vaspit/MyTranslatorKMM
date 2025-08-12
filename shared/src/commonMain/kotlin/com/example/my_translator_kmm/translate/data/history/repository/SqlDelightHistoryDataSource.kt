package com.example.my_translator_kmm.translate.data.history.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.my_translator_kmm.core.domain.util.CommonFlow
import com.example.my_translator_kmm.core.domain.util.toCommonFlow
import com.example.my_translator_kmm.database.TranslateDatabase
import com.example.my_translator_kmm.translate.data.history.mappers.toDomain
import com.example.my_translator_kmm.translate.domain.history.model.HistoryItem
import com.example.my_translator_kmm.translate.domain.history.repository.HistoryDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
) : HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { history ->
                history.map { it.toDomain() }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timeStamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}
