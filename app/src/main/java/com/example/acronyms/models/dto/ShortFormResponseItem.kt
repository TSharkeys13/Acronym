package com.example.acronyms.models.dto

@kotlinx.serialization.Serializable
data class ShortFormResponseItem(
    val lfs: List<Lf> = emptyList(),
    val sf: String = "",
)
