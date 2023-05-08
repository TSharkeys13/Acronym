package com.example.acronyms.models.remote

import com.example.acronyms.models.dto.ShortFormResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymService {
    @GET(DICT_ENDPOINT)
    suspend fun getWordFromAcronym(@Query(SF) initials: String): Response<ArrayList<ShortFormResponseItem>>

    companion object {
        const val DICT_ENDPOINT = "dictionary.py"
        const val SF = "sf"
    }
}
