package br.com.validation.request.validationRequest.usecase.mapper

import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.entity.QrCodeEntity

fun QrCodeEntity.domainToQrCodeResponse() = QrCode(
    transactionId = this.transactionId,
    amount = this.amount,
    endToEndId = this.endToEndId
)