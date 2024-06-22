package br.com.validation.request.validationRequest.domain

import java.math.BigDecimal

data class QrCode (

    val transactionId: String,
    val amount: BigDecimal,
    val endToEndId: String
)