package com.issuemoa.auth.presentation.dto

import java.io.Serializable

data class Passport(
    val id: Int,
    val name: String,
    val deviceType: String
) : Serializable {
}