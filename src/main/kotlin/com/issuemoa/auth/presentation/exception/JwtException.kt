package com.issuemoa.auth.presentation.exception

import com.issuemoa.auth.infrastructure.ErrorCode
import com.issuemoa.auth.infrastructure.ErrorException
import org.springframework.http.HttpStatus

class JwtException(message: String, error: ErrorCode? = null) : ErrorException(HttpStatus.NOT_FOUND.value(), message, error) {
}