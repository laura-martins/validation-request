package br.com.validation.request.validationRequest.port

import br.com.validation.request.validationRequest.domain.QrCode
import java.math.BigDecimal


interface QrCodePort {

    fun findById(transactionId: String) : QrCode

    fun save(amount: BigDecimal) : QrCode
}