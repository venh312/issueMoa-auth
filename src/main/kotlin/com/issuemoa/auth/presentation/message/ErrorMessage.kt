package com.issuemoa.auth.presentation.message

import com.issuemoa.auth.infrastructure.ErrorCode

data class ErrorMessage(
    val statusCode: Int,
    val message: String,
    val error: ErrorCode? = null
) {
}