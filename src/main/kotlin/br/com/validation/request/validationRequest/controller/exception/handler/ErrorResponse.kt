package br.com.validation.request.validationRequest.controller.exception.handler

class ErrorResponse (

    val status: Int,
    val erros: String,
    val message: String,
    val path: String
)