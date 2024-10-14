package br.com.validation.request.validationRequest.controller.handler

data class ErrorResponse(

    val status: Int,
    val message: String,
    val errors: Map<String?, String?>, // TODO: Ajustar
    val path: String
)