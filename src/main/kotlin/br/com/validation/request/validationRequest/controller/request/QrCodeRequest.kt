package br.com.validation.request.validationRequest.controller.request

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class QrCodeRequest(

    @field:DecimalMin(value = "0.01", inclusive = true, message = "Amount must be greater than zero")
    @field:Digits(integer = 10, fraction = 2, message = "Amount must have up to 2 decimal places")
    val amount: Double,

    @field:Size(max = 255, message = "Description must be up to 255 characters")
    val description: String? = null,

    //TODO: Como validar se o que foi passado, foi uma data valida?
    val expirationDate: LocalDateTime? = null
)