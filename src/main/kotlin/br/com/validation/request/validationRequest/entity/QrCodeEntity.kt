package br.com.validation.request.validationRequest.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "tb_qrcodes")
data class QrCodeEntity (

    @Id
    @Column(name = "transaction_id", length = 34)
    var transactionId: String = "",

    @Column(name = "amount", precision = 10, scale = 2)
    val amount: BigDecimal = BigDecimal.ZERO,

    @Column(name = "end_to_end_id", length = 32)
    val endToEndId: String = ""
)