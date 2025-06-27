package br.com.validation.request.validationRequest.controller.request.validator

fun String.trimAndReduceWhitespaces(): String {
    return this.trim()
        .replace(Regex("\\s+"), " ")
}

fun String.removeAllWhitespaces(): String {
    return this.replace(Regex("\\s+"), "")
}