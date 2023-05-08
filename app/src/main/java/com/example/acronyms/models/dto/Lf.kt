package com.example.acronyms.models.dto

@kotlinx.serialization.Serializable
class Lf(
    val freq: Int = 0,
    val lf: String = "",
    val since: Int = 0,
    val vars: List<Var> = emptyList(),
)
