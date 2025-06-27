package br.com.validation.request.validationRequest.controller.handler

import br.com.validation.request.validationRequest.exception.NotFoundQrCodeException
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.ConstraintViolationException
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class ControllerHandlerAdvice(
    private val messageSource: MessageSource
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

        print("Error occurred: ${errorResponse.message}, Path: ${errorResponse.path}, Time: ${LocalDateTime.now()}, Exception: $exception")

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
            errors = getBindingResultErrors(bindingResult),
            message = "We cannot fulfill your request due to invalid or incomplete data",
            path = request.requestURI
        )

        print("Error occurred: ${errorResponse.message}, Path: ${errorResponse.path}, Time: ${LocalDateTime.now()}, Exception: $exception")

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(
        exception: ConstraintViolationException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {

        val httpStatusError = HttpStatus.BAD_REQUEST

        val errorResponse = ErrorResponse(
            status = httpStatusError.value(),
            errors = getConstraintViolationErrors(exception),
            message = "We cannot fulfill your request due to invalid or incomplete data",
            path = request.requestURI
        )

        print("Error occurred: ${errorResponse.message}, Path: ${errorResponse.path}, Time: ${LocalDateTime.now()}, Exception: $exception")

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(
        exception: HttpMessageNotReadableException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {

        val httpStatusError = HttpStatus.BAD_REQUEST

        val errorResponse = ErrorResponse(
            status = httpStatusError.value(),
            errors = mutableListOf(),
            message = "Malformed JSON or incompatible data types",
            path = request.requestURI
        )

        print("Error occurred: ${errorResponse.message}, Path: ${errorResponse.path}, Time: ${LocalDateTime.now()}, Exception: ${exception}")

        return ResponseEntity.status(httpStatusError).body(errorResponse)
    }

    private final fun getBindingResultErrors(
        bindingResult: BindingResult
    ): MutableList<FieldErrorDto> {
        return bindingResult.allErrors.map { error ->
            val message = messageSource.getMessage(error, LocaleContextHolder.getLocale())
            val name = if (error is FieldError) error.field else error.objectName
            val valueField = if (error is FieldError) error.rejectedValue.toString() else ""
            FieldErrorDto(field = name, message = message, value = valueField)
        }.toMutableList()
    }

    private final fun getConstraintViolationErrors(
        constraintViolationException: ConstraintViolationException
    ): MutableList<FieldErrorDto> {
        return constraintViolationException.constraintViolations.map { violation ->
            val message = violation.message
            val name = violation.propertyPath.toString()
            val valueField = violation.invalidValue?.toString() ?: ""
            FieldErrorDto(field = name, message = message, value = valueField)
        }.toMutableList()
    }
}