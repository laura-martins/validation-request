package br.com.validation.request.validationRequest.adapter.mapper

import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.exception.NotFoundQrCodeException
import br.com.validation.request.validationRequest.port.FindQrCodePort
import br.com.validation.request.validationRequest.port.QrCodeRepository
import org.springframework.stereotype.Component

@Component
class QrCodeRepositoryAdapter(
    private val qrCodeRepository: QrCodeRepository
) : FindQrCodePort {

    override fun findById(transactionId: String): QrCode {
        val entity = qrCodeRepository.findById(transactionId).orElseThrow {
            NotFoundQrCodeException("QR Code not found with transactionId=[$transactionId]")
        }

        return entity.toDomain()
    }
}