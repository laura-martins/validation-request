package br.com.validation.request.validationRequest.usecase

import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.port.QrCodePort
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class CreateQrCodeUseCase(
    private val qrCodePort: QrCodePort
) {

    fun execute(amount: BigDecimal): QrCode {
        return qrCodePort.save(amount)
    }
}