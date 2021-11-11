package com.ninaestoye.findfun.model

data class QueryResponse(
    val response_code: Int,
    val results: List<Question>
)
