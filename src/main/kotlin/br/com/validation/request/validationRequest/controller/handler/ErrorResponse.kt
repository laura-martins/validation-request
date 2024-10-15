package br.com.validation.request.validationRequest.controller.handler

import java.time.LocalDateTime

data class ErrorResponse(

    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val message: String,
    val errors: List<FieldError>,
    val path: String
)