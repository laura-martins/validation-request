package br.com.validation.request.validationRequest.usecase

import br.com.validation.request.validationRequest.controller.exception.NotFoundQrCodeException
import br.com.validation.request.validationRequest.controller.mapper.domainToQrCodeResponse
import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.port.FindQrCodePort
import br.com.validation.request.validationRequest.port.QrCodeRepository
import br.com.validation.request.validationRequest.usecase.mapper.domainToQrCodeResponse
import org.springframework.stereotype.Component

@Component
class FindQrCodeUseCase(
    private val qrCodeRepository: QrCodeRepository
) : FindQrCodePort {

    override fun findById(transactionId: String): QrCode {
        try {
            val qrCodeEntity = qrCodeRepository.findById(transactionId).orElseThrow {
                NotFoundQrCodeException("QR Code not found with transactionId=[$transactionId]")
            }

            return qrCodeEntity.domainToQrCodeResponse()

        } catch (ex: Exception) {
            throw ex
        }
    }
}