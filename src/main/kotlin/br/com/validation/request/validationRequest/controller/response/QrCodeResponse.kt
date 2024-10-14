package br.com.validation.request.validationRequest.controller.response

import java.math.BigDecimal
import java.time.LocalDateTime

data class QrCodeResponse (

    val transactionId: String,
    val amount: BigDecimal,
    val createdAt: LocalDateTime
)