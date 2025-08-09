package com.example.my_translator_kmm.core.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

class IosMutableStateFlow<T>(
    initialValue: T
): CommonMutableStateFlow<T>(MutableStateFlow(initialValue))
