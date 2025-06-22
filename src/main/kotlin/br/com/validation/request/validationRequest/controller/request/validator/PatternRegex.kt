package br.com.validation.request.validationRequest.controller.request.validator

object PatternRegex {
    const val UUID_VALID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"
    const val CNPJ_VALID = "^\\d{14}$"
}