package br.com.validation.request.validationRequest.domain

import java.math.BigDecimal
import java.time.LocalDateTime

data class QrCode (

    val transactionId: String,
    val amount: BigDecimal,
    val createdAt: LocalDateTime
)