package br.com.validation.request.validationRequest.controller.mapper

import br.com.validation.request.validationRequest.controller.request.QrCodeRequest
import br.com.validation.request.validationRequest.domain.QrCode

fun QrCodeRequest.toQrCode() = QrCode(
    amount = this.amount,
    description = this.description,
    expirationDate = this.expirationDate
)