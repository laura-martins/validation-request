package br.com.validation.request.validationRequest.controller.response

import java.time.LocalDateTime

data class QrCodeResponse (

    val transactionId: String,
    val amount: Double,
    val createdAt: LocalDateTime,
    val description: String?,
    val expirationDate: LocalDateTime?
)