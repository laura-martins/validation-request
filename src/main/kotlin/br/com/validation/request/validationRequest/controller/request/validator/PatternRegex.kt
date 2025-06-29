package br.com.validation.request.validationRequest.controller.request.validator

object PatternRegex {
    const val UUID_VALID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"
    const val CNPJ_VALID = "^\\d{14}$"

    /*
        customer.name
        customer.fantasyName
        verificar se pode : ; D'Vila D’Vila
    */

    /*
        customer.name
        customer.fantasyName
        customer.addresses.streetAddress
        verificar se tem seller com esseas vogais äèëìïòöùüñ
    */

    /*
        customer.name
        customer.fantasyName
        pode iniciar com caracter especial
     */

    /*
        customer.addresses.number
        verificar se sequencia de 2 é apenas para letras ou númeroa também devem ser incluídos
     */

    /*
        customer.addresses.neighborhood
        verificar se pode ser só número mesmo
     */
    const val CUSTOMER_NAME_VALID = "(?iu)^(?!\\d+\$)(?!.*([\\p{L}])\\1{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’!@#\$+%¨&*()_=\\/|.,!?\\-]*\$"
    const val FANTASY_NAME_VALID = "(?iu)^(?!\\d+\$)(?!.*([\\p{L}])\\1{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’!@#\$+%¨&*()_=\\/|.,!?~\\-ªº\\[\\]§°]*\$"
    const val STREET_ADDRESS_VALID = "(?iu)^(?![ªº])(?!\\d+\$)(?!.*([\\p{L}])\\1{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõÁÉÍÓÚÂÊÎÔÛÃÕ0-9][a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’\\/\\-,()ªº]*\$"
    const val NUMBER_ADDRESS_VALID = "(?iu)^((?!.*([a-zA-Z])\\2{2})(?=.*[0-9])[a-zA-Z0-9][a-zA-Z0-9\\s\\-\\/\\,ªº]*)\$|^SN\$"
    const val COMPLEMENTARY_ADDRESS = "(?iu)^(?![ªº])(?!\\d+\$)(?!.*([\\p{L}])\\1{4})(?=.*[\\p{L}])[a-záéíóúâêîôûãõÁÉÍÓÚÂÊÎÔÛÃÕ0-9][a-záéíóúâêîôûãõçñàÁÉÍÓÚÂÊÎÔÛÃÕÇÑÀ0-9\\s'’\\/\\-,()ªº]*\$"
    const val NEIGHBORHOOD_VALID = "(?iu)^(?![ªçÇº])(?!.*([\\p{L}])\\1{4})[a-záéíóúâêîôûãõÁÉÍÓÚÂÊÎÔÛÃÕ0-9][a-záéíóúâêîôûãõçÁÉÍÓÚÂÊÎÔÛÃÕÇ0-9\\s'’\\-/]*\$"
}