package com.example.my_translator_kmm.translate.data.local

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {

    fun create(): SqlDriver
}
