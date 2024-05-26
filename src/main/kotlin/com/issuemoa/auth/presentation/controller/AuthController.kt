package com.issuemoa.auth.presentation.controller

import com.issuemoa.auth.presentation.dto.Passport
import com.issuemoa.auth.presentation.dto.PassportRequest
import com.issuemoa.auth.presentation.jwt.TokenProvider
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(val tokenProvider: TokenProvider) {
    @PostMapping("/passport")
    fun issuePassport(@RequestBody passportRequest: PassportRequest): Passport {
        return tokenProvider.getPassport(passportRequest);
    }
}