package com.issuemoa.auth.infrastructure

open class ErrorException(
    val statusCode: Int,
    val customMessage: String,
    val error: ErrorCode? = null
) : RuntimeException() {
}