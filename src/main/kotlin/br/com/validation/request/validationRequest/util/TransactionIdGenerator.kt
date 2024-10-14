package br.com.validation.request.validationRequest.util

import java.util.*

fun generateTransactionId(): String {
    return "OQRC" + UUID.randomUUID().toString().replace("-", "").take(30)
}