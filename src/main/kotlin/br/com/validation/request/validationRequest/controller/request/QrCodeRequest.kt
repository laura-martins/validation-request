package br.com.validation.request.validationRequest.controller.request

import java.math.BigDecimal
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

data class QrCodeRequest(

    @field:NotNull(message = "Amount cannot be null")
    @field:DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than zero")
    @field:Digits(integer = 10, fraction = 2, message = "Amount must have up to 2 decimal places")
    val amount: BigDecimal
)