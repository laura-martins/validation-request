package br.com.validation.request.validationRequest.usecase

import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.port.QrCodePort
import org.springframework.stereotype.Component

@Component
class CreateQrCodeUseCase(
    private val qrCodePort: QrCodePort
) {

    fun execute(amount: Double): QrCode {
        return qrCodePort.save(amount)
    }
}