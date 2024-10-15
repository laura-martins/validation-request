package br.com.validation.request.validationRequest.util.validator

import br.com.validation.request.validationRequest.util.annotation.ValidExpirationDate
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDateTime

class ExpirationDateValidator : ConstraintValidator<ValidExpirationDate, LocalDateTime?> {
    override fun isValid(value: LocalDateTime?, context: ConstraintValidatorContext): Boolean {
        return value == null || !value.isBefore(LocalDateTime.now())
    }
}