package br.com.validation.request.validationRequest.adapter.mapper

import br.com.validation.request.validationRequest.domain.QrCode
import br.com.validation.request.validationRequest.exception.NotFoundQrCodeException
import br.com.validation.request.validationRequest.port.QrCodePort
import br.com.validation.request.validationRequest.port.QrCodeRepository
import br.com.validation.request.validationRequest.util.generateTransactionId
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDateTime

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

    override fun save(amount: BigDecimal): QrCode {
        try {
            val qrCode = QrCode(
                transactionId = generateTransactionId(),
                amount = amount,
                createdAt = LocalDateTime.now())

            val entity = qrCode.toEntity(qrCode.transactionId)

            val savedEntity = qrCodeRepository.save(entity)

            return savedEntity.toDomain()
        } catch (e: Exception) {
            throw e
        }
    }
}