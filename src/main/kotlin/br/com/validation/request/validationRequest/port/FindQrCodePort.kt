package br.com.validation.request.validationRequest.port

import br.com.validation.request.validationRequest.domain.QrCode


interface FindQrCodePort {

    fun findById(transactionId: String) : QrCode
}