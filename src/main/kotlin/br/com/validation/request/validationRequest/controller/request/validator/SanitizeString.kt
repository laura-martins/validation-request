package br.com.validation.request.validationRequest.controller.request.validator

fun String.trimAndReduceWhitespaces(): String {
    // Remove espaços no início e no fim e substitui múltiplos espaços por um único espaço
    return this.trim()
        .replace(Regex("\\s+"), " ")
}

fun String.removeAllWhitespaces(): String {
    return this.replace(Regex("\\s+"), "")
}

fun String.validateNonASCIICharacters(): String {
    // Verifica se há caracteres não ASCII e estoura exceção
    if (Regex("[^\\p{ASCII}]").containsMatchIn(this)) {
        throw IllegalArgumentException("A string contém caracteres não ASCII.")
    }
    return this
}

fun String.validateForeignCharacters(): String {
    // Verifica se há caracteres estrangeiros e estoura exceção
    if (Regex("[^\\p{ASCII}]").containsMatchIn(this)) {
        throw IllegalArgumentException("A string contém caracteres estrangeiros.")
    }
    return this
}