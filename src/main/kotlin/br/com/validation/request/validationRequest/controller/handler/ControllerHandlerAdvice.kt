package br.com.validation.request.validationRequest.controller.handler

import br.com.validation.request.validationRequest.exception.NotFoundQrCodeException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

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
            message = exception.cause?.message ?: "Not Found",
            errors = mapOf("error" to "Not Found"), // TODO: Ajustar
            path = request.requestURI
        )

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }

    // TODO: Ajustar
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {

        val httpStatusError = HttpStatus.BAD_REQUEST

        val errorResponse = ErrorResponse(
            status = httpStatusError.value(),
            message = "Validation Error",
            errors = exception.bindingResult.fieldErrors.associate { it.field to it.defaultMessage },
            path = request.requestURI
        )

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }
}