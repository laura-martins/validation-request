package br.com.validation.request.validationRequest.controller.request.validator

object PatternRegex {
    const val UUID_VALID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"
    const val CNPJ_VALID = "^\\d{14}$"

    // : ;
    // verificar se tem seller com esseas vogais äèëìïòöùü
    const val CUSTOMER_NAME_VALID = "(?iu)^(?!\\d+$)(?!.*([\\p{L}])\\1{4})(?=.*\\s)[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'!@#\\\$+%¨&*()_=\\/|.,!?\\-]+$"
    const val FANTASY_NAME_VALID = "(?iu)^(?!\\d+$)(?!.*([\\p{L}])\\1{4})(?=.*\\s)[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'!@#\\\$+%¨&*()_=\\/|.,!?\\-ªº\\[\\]§°]+$"
}