package br.com.validation.request.validationRequest.controller.request.validator

import br.com.validation.request.validationRequest.controller.request.annotation.ValidPixKey
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PixKeyValidator : ConstraintValidator<ValidPixKey, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        if (value.isNullOrBlank()) return false

        return when {
            value.matches(Regex("\\d{11}")) -> isValidCPF(value) // CPF validation
            value.matches(Regex("\\d{14}")) -> isValidCNPJ(value) // CNPJ validation
            value.startsWith("+") -> isValidPhone(value) // Phone validation
            value.matches(Regex("[0-9a-fA-F-]{36}")) -> isValidUUID(value) // UUID validation
            value.contains("@") -> isValidEmail(value) // Email validation
            else -> false
        }
    }

    private fun isValidCPF(cpf: String): Boolean {
        return cpf.length == 11 // Add further CPF validation logic if needed
    }

    private fun isValidCNPJ(cnpj: String): Boolean {
        return cnpj.length == 14 // Add further CNPJ validation logic if needed
    }

    private fun isValidPhone(phone: String): Boolean {
        return phone.matches(Regex("\\+\\d+")) // Basic phone validation
    }

    private fun isValidUUID(uuid: String): Boolean {
        return try {
            java.util.UUID.fromString(uuid)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val regex = "^(?!.*://)(?!www\\.)[^@]+@[^@]+\\..+$"
        return email.matches(Regex(regex)) // Basic email validation without TLD validation
    }
}