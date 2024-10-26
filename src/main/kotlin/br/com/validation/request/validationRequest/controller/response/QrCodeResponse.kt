package br.com.validation.request.validationRequest.controller.response

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class QrCodeResponse (

    val transactionId: String,
    val amount: Double,
    val createdAt: LocalDateTime,
    val description: String?,
    val expirationDate: LocalDateTime?
)