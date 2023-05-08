package com.example.acronyms.models

import com.example.acronyms.models.remote.AcronymService
import javax.inject.Inject

class AcronymRepository @Inject constructor(private val acronymService: AcronymService) {
    suspend fun getWordsFromAcronym(acronym: String): List<String> {
        return acronymService.getWordFromAcronym(acronym)
            .body()
            ?.firstOrNull()
            ?.lfs
            ?.map { it.lf }
            ?: emptyList()
    }
}
