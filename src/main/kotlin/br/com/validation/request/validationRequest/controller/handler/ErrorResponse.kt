package br.com.validation.request.validationRequest.controller.handler

import java.sql.Timestamp
import java.time.Instant

data class ErrorResponse(

    val timestamp: String = Timestamp.from(Instant.now()).toString(),
    val status: Int,
    val errors: MutableList<FieldErrorDto>? = null,
    val message: String,
    val path: String
)