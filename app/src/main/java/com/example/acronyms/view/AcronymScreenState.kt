package com.example.acronyms.view

data class AcronymScreenState(
    val isLoading: Boolean = false,
    val response: List<String> = emptyList(),
    val showResultText: Boolean = false,
    val errorTextId: Int? = null,
)
