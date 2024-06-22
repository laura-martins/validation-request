package br.com.validation.request.validationRequest.controller.response

import java.math.BigDecimal

data class QrCodeResponse (

    val transactionId: String,
    val amount: BigDecimal,
    val endToEndId: String
)