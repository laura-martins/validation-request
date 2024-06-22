package br.com.validation.request.validationRequest.controller.exception.handler

import br.com.validation.request.validationRequest.controller.exception.NotFoundQrCodeException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class ControllerHandlerAdvice {

    @ExceptionHandler(NotFoundQrCodeException::class)
    fun handlerNotFoundQrCodeException(
        exception: Exception,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {

        val httpStatusError = HttpStatus.NOT_FOUND

        val errorResponse = ErrorResponse(
            status = httpStatusError.value(),
            erros = "Not Found",
            message = exception.cause?.message ?: "Not Found",
            path = request.requestURI
        )

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }
}