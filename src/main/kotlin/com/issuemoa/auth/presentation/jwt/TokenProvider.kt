package com.issuemoa.auth.presentation.jwt

import com.issuemoa.auth.infrastructure.ErrorCode
import com.issuemoa.auth.presentation.dto.Passport
import com.issuemoa.auth.presentation.dto.PassportRequest
import com.issuemoa.auth.presentation.exception.JwtException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class TokenProvider {
    @Value("\${jwt.secretKey}")
    lateinit var secretKey: String

    private fun getClaims(token: String?): Claims {
        try {
            return Jwts.parserBuilder().setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            throw JwtException(e.message.toString(), ErrorCode.JWT_ERROR)
        }
    }

    fun getPassport(passportRequest: PassportRequest): Passport {
        println("==> [TokenProvider] getPassport")
        val claims = getClaims(passportRequest.token)
        return Passport(
            id = claims["id"] as Int,
            name = claims["name"] as String,
            deviceType = passportRequest.deviceType
        )
    }
}