package br.com.validation.request.validationRequest.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tb_qrcodes")
data class QrCodeEntity (

    @Id
    @Column(name = "transaction_id", length = 34)
    var transactionId: String = "",

    @Column(name = "amount")
    val amount: Double = 0.0,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)