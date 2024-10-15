package br.com.validation.request.validationRequest.adapter

import br.com.validation.request.validationRequest.adapter.mapper.toDomain
import br.com.validation.request.validationRequest.adapter.mapper.toEntity
import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.exception.NotFoundQrCodeException
import br.com.validation.request.validationRequest.port.QrCodePort
import br.com.validation.request.validationRequest.port.QrCodeRepository
import org.springframework.stereotype.Component

@Component
class QrCodeRepositoryAdapter(
    private val qrCodeRepository: QrCodeRepository
) : QrCodePort {

    override fun findById(transactionId: String): QrCode {
        try {
            val entity = qrCodeRepository.findById(transactionId).orElseThrow {
                NotFoundQrCodeException("QR Code not found with transactionId=[$transactionId]")
            }

            return entity.toDomain()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun save(qrCode: QrCode): QrCode {
        try {
            val entity = qrCode.toEntity(qrCode.transactionId)

            val savedEntity = qrCodeRepository.save(entity)

            return savedEntity.toDomain()
        } catch (e: Exception) {
            throw e
        }
    }
}