package br.com.validation.request.validationRequest.controller.mapper

import br.com.validation.request.validationRequest.controller.response.QrCodeResponse
import br.com.validation.request.validationRequest.domain.QrCode

fun QrCode.domainToQrCodeResponse() = QrCodeResponse(
    transactionId = this.transactionId,
    amount = this.amount,
    createdAt = this.createdAt
)