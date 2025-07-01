package br.com.validation.request.validationRequest.controller.request.validator

object PatternRegex {
    const val UUID_VALID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"
    const val CNPJ_VALID = "^\\d{14}$"

    // remover ¨ e ! (duplicado)
    const val CUSTOMER_NAME_VALID = "(?iu)^(?!\\d+\$)(?!.*([\\p{L}])\\1{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’!@#\$+%&*()_=\\/|.,?\\-]*\$"

    // remover ¨ e ! (duplicado)
    const val FANTASY_NAME_VALID = "(?iu)^(?!\\d+\$)(?!.*([\\p{L}])\\1{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’!@#\$+%&*()_=\\/|.,?~\\-ªº\\[\\]§°]*\$"
    const val STREET_ADDRESS_VALID = "(?iu)^(?!\\d+\$)(?!.*([\\p{L}])\\1{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõÁÉÍÓÚÂÊÎÔÛÃÕ0-9][a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’\\/\\-,()ªº]*\$"
    const val NUMBER_ADDRESS_VALID = "(?iu)^((?!.*([a-zA-Z])\\2{2})(?=.*[0-9])[a-zA-Z0-9][a-zA-Z0-9\\s\\-\\/\\,ªº]*)\$|^SN\$"

    //regex ajustada, agora aceita vazio, precisa ajustar o message.atributte pra esse campo
    const val COMPLEMENTARY_ADDRESS = "(?iu)^(\\s*\$|(?!(\\d+\$))(?!.*([\\p{L}])\\3{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõÁÉÍÓÚÂÊÎÔÛÃÕ0-9][a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’/\\-,()ªº]*\$)"



    const val NEIGHBORHOOD_VALID = "(?iu)^(?!.*([\\p{L}])\\1{4})[a-záéíóúâêîôûãõÁÉÍÓÚÂÊÎÔÛÃÕ0-9][a-záéíóúâêîôûãõçÁÉÍÓÚÂÊÎÔÛÃÕÇ0-9\\s'’\\-/]*\$"

    // add os dois tipos de apostrofo '’
    const val CITY_VALID = "(?iu)^(?!.*([\\p{L}])\\1{4})(?!.*[0-9])[a-záéíóúâêîôûãõÁÉÍÓÚÂÊÎÔÛÃÕ][a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ\\s'\\-]*$"
}