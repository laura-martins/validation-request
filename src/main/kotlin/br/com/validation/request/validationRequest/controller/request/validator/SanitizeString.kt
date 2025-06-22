package br.com.validation.request.validationRequest.controller.request.validator

fun String.normalizeAndTrimWhitespaces(): String {
    return this.trimAndReduceWhitespaces() // Limpa espaços em branco
        .validateNonASCIICharacters() // Verifica caracteres não ASCII
        .validateForeignCharacters() // Verifica caracteres estrangeiros
}

fun String.normalizeAndRemoveAllWhitespaces(): String {
    return this.removeAllWhitespaces() // Limpa espaços em branco
        .validateNonASCIICharacters() // Verifica caracteres não ASCII
        .validateForeignCharacters() // Verifica caracteres estrangeiros
}

private fun String.trimAndReduceWhitespaces(): String {
    // Remove espaços no início e no fim e substitui múltiplos espaços por um único espaço
    return this.trim()
        .replace(Regex("\\s+"), " ")
}

private fun String.removeAllWhitespaces(): String {
    return this.replace(Regex("\\s+"), "")
}

private fun String.validateNonASCIICharacters(): String {
    // Verifica se há caracteres não ASCII e estoura exceção
    if (Regex("[^\\p{ASCII}]").containsMatchIn(this)) {
        throw IllegalArgumentException("A string contém caracteres não ASCII.")
    }
    return this
}

private fun String.validateForeignCharacters(): String {
    // Verifica se há caracteres estrangeiros e estoura exceção
    if (Regex("[^\\p{ASCII}]").containsMatchIn(this)) {
        throw IllegalArgumentException("A string contém caracteres estrangeiros.")
    }
    return this
}