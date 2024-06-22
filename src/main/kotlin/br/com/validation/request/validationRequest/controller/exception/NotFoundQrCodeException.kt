package br.com.validation.request.validationRequest.controller.exception

class NotFoundQrCodeException(
    message: String,
    cause: Throwable? = null
) : Throwable(message, cause)
