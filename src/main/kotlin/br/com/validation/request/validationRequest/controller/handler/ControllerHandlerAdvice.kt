package br.com.validation.request.validationRequest.controller.handler

import br.com.validation.request.validationRequest.exception.NotFoundQrCodeException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerHandlerAdvice(
    val messageSource: MessageSource
) {

    @ExceptionHandler(NotFoundQrCodeException::class)
    fun handlerNotFoundQrCodeException(
        exception: Exception,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {

        val httpStatusError = HttpStatus.NOT_FOUND

        val errorResponse = ErrorResponse(
            status = httpStatusError.value(),
            errors = mutableListOf(),
            message = exception.cause?.message ?: "Not Found",
            path = request.requestURI
        )

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest,
        bindingResult: BindingResult
    ): ResponseEntity<ErrorResponse> {

        val httpStatusError = HttpStatus.BAD_REQUEST

        val errorResponse = ErrorResponse(
            status = httpStatusError.value(),
            errors = getDetailsBeanValidationErrors(bindingResult),
            message = "We cannot fulfill your request due to invalid or incomplete data",
            path = request.requestURI
        )

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }

    private final fun getDetailsBeanValidationErrors(
        bindingResult: BindingResult
    ): MutableList<FieldErrorDto> {
        return bindingResult.allErrors.map { error ->
            val message = messageSource.getMessage(error, LocaleContextHolder.getLocale())
            val name = if (error is FieldError) error.field else error.objectName
            val valueField = if (error is FieldError) error.rejectedValue.toString() else ""
            FieldErrorDto(field = name, message = message, value = valueField)
        }.toMutableList()
    }
}