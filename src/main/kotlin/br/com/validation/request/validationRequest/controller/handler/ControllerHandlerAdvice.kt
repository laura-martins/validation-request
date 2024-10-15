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
            errors = listOf(),
            path = request.requestURI
        )

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {

        val httpStatusError = HttpStatus.BAD_REQUEST

        val fieldErrors = exception.bindingResult.fieldErrors.map {
            FieldError(it.field, it.defaultMessage ?: "Invalid value")
        }

        val errorResponse = ErrorResponse(
            status = httpStatusError.value(),
            message = "Bad Request",
            errors = fieldErrors,
            path = request.requestURI
        )

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }
}