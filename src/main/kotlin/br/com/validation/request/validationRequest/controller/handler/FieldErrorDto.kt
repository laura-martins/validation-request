package br.com.validation.request.validationRequest.controller.handler

data class FieldErrorDto(
    val field: String?,
    val message: String?,
    val value: String?
)