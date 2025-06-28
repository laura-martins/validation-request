package br.com.validation.request.validationRequest.controller.request.validator

object PatternRegex {
    const val UUID_VALID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"
    const val CNPJ_VALID = "^\\d{14}$"

    // : ;
    // verificar se tem seller com esseas vogais äèëìïòöùü
    const val CUSTOMER_NAME_VALID = "(?iu)^(?!\\d+$)(?!\\s+\$)(?!.*([\\p{L}])\\1{4})(?=.*[a-zA-Z])[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’!@#\\\$+%¨&*()_=\\/|.,!?\\-]+$"
    const val FANTASY_NAME_VALID = "(?iu)^(?!\\d+$)(?!\\s+$)(?!.*([\\p{L}])\\1{4})(?=.*[a-zA-Z])[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’!@#\\\$+%¨&*()_=\\/|.,!?~\\-ªº\\[\\]§°]+$"
    const val STREET_ADDRESS_VALID = "(?iu)^[\\p{L}\\d](?!.*([\\p{L}])\\1{4})(?!\\d+$)(?=.*\\b[\\p{L}][^\\s]*\\s+[\\p{L}][^\\s]*)[\\p{L}\\d\\s'\\-\\/\\,\\(\\)ao]+$"
}