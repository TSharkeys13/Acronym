package com.example.acronyms.models.dto

@kotlinx.serialization.Serializable
data class Var(
    val freq: Int = 0,
    val lf: String = "",
    val since: Int = 0,
)
