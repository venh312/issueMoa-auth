package com.issuemoa.auth.presentation.exception

import com.issuemoa.auth.infrastructure.ErrorException
import com.issuemoa.auth.presentation.message.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ErrorException::class)
    fun handleJwtVerificationException(e: ErrorException):ResponseEntity<ErrorMessage> {
        val exceptionResult = ErrorMessage(e.statusCode, e.customMessage, e.error)
        return ResponseEntity(exceptionResult, HttpStatus.valueOf(e.statusCode))
    }
}