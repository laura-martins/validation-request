package br.com.validation.request.validationRequest.usecase

import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.port.FindQrCodePort
import org.springframework.stereotype.Component

@Component
class FindQrCodeUseCase(
    private val findQrCodePort: FindQrCodePort
) {

    fun execute(transactionId: String): QrCode {
        return findQrCodePort.findById(transactionId)
    }
}