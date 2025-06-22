package br.com.validation.request.validationRequest.domain

data class Onboarding (

    val customerId: String,
    val destinationAccoutns: List<DestinationAccount>?,
    val customer: Customer
) {
    data class DestinationAccount(
        val key: String,
        val percent: Int,
    )
    data class Customer(
        val documentNumber: String,
        val name: String,
        val incomeInvoicing: Int
    )
}