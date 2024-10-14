package br.com.validation.request.validationRequest.port

import br.com.validation.request.validationRequest.domain.QrCode


interface QrCodePort {

    fun findById(transactionId: String) : QrCode

    fun save(amount: Double) : QrCode
}