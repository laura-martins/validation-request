package br.com.validation.request.validationRequest.adapter.mapper

import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.entity.QrCodeEntity

fun QrCodeEntity.toDomain(): QrCode {
    return QrCode(
        transactionId = this.transactionId,
        amount = this.amount,
        createdAt = this.createdAt
    )
}

fun QrCode.toEntity(transactionId: String): QrCodeEntity {
    return QrCodeEntity(
        transactionId = transactionId,
        amount = this.amount
    )
}