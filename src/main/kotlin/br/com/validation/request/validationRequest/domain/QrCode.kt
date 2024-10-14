package br.com.validation.request.validationRequest.domain

import java.time.LocalDateTime

data class QrCode (

    val transactionId: String,
    val amount: Double,
    val createdAt: LocalDateTime
)