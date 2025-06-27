package br.com.validation.request.validationRequest.domain

data class Onboarding (

    val correlationId: String,
    val automationOrangePartnerId: String,
    val integrationOrangePartnerId: String?,
    val destinationAccounts: List<DestinationAccount>?,
    val customer: Customer
) {
    data class DestinationAccount(
        val key: String,
        val percent: Int,
    )
    data class Customer(
        val documentNumber: String,
        val name: String,
        val fantasyName: String,
        val incomeInvoicing: Int
    )
}