package br.com.validation.request.validationRequest.domain

import java.time.LocalDateTime
import java.util.*

data class QrCode (

    val transactionId: String = generateTransactionId(),
    val amount: Double,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val description: String?,
    val expirationDate: LocalDateTime? = createdAt.plusMinutes(5)
) {

    companion object {
        private fun generateTransactionId(): String {
            return "OQRC" + UUID.randomUUID().toString().replace("-", "").take(30)
        }
    }
}