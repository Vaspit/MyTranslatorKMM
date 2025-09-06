package com.example.my_translator_kmm.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_translator_kmm.translate.domain.history.repository.HistoryDataSource
import com.example.my_translator_kmm.translate.domain.translate.TranslateUseCase
import com.example.my_translator_kmm.translate.presentation.TranslateEvent
import com.example.my_translator_kmm.translate.presentation.TranslateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translateUseCase: TranslateUseCase,
    private val historyDataSource: HistoryDataSource
) : ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translateUseCase = translateUseCase,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}
