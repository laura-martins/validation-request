package br.com.validation.request.validationRequest.controller.request

import br.com.validation.request.validationRequest.controller.request.annotation.ValidPixKey
import br.com.validation.request.validationRequest.controller.request.validator.PatternRegex
import br.com.validation.request.validationRequest.controller.request.validator.removeAllWhitespaces
import br.com.validation.request.validationRequest.controller.request.validator.trimAndReduceWhitespaces
import br.com.validation.request.validationRequest.domain.Onboarding
import jakarta.validation.Valid
import jakarta.validation.constraints.*

data class OnboardingRequest (

    @field:[NotBlank Pattern(regexp = PatternRegex.UUID_VALID)]
    val correlationId: String,

    @field:[NotBlank Pattern(regexp = PatternRegex.UUID_VALID)]
    val automationOrangePartnerId: String,

    @field:[Pattern(regexp = PatternRegex.UUID_VALID)]
    val integrationOrangePartnerId: String?,

    @field:[Size(min = 1, max = 1) Valid]
    val destinationAccounts: List<DestinationAccount>?,

    @field:[NotNull Valid]
    val customer: Customer
) {
    data class DestinationAccount(
        @field:[NotBlank Size(max = 77) ValidPixKey]
        val key: String,

        @field:[NotNull Min(100) Max(100)]
        val percent: Int,
    )

    data class Customer(
        @field:[NotBlank Pattern(regexp = PatternRegex.CNPJ_VALID)]
        val documentNumber: String,

        @field:[NotBlank Size(min = 3, max = 200) Pattern(regexp = PatternRegex.CUSTOMER_NAME_VALID)]
        val name: String,

        @field:[NotNull Size(min = 3, max = 60) Pattern(regexp = PatternRegex.FANTASY_NAME_VALID)]
        val fantasyName: String,

        @field:[Min(1)]
        val incomeInvoicing: Int,

        @field:[NotNull Size(min = 1, max = 1) Valid]
        val addresses: List<CustomerAddress>,
    )

    data class CustomerAddress(
        @field:[NotBlank Pattern(regexp = "(?i)^CNPJ_CARD$")]
        val purpose: String,
    )

    companion object {
        fun OnboardingRequest.convertToOnboarding(): Onboarding {
            return Onboarding(
                correlationId = this.correlationId.lowercase(),
                automationOrangePartnerId = this.automationOrangePartnerId.lowercase(),
                integrationOrangePartnerId = this.integrationOrangePartnerId?.lowercase(),
                destinationAccounts = this.destinationAccounts?.map {
                    Onboarding.DestinationAccount(
                        key = it.key.removeAllWhitespaces().lowercase(),
                        percent = it.percent
                    )
                },
                customer = Onboarding.Customer(
                    documentNumber = this.customer.documentNumber.lowercase(),
                    name = this.customer.name.trimAndReduceWhitespaces().uppercase(),
                    fantasyName = this.customer.fantasyName.trimAndReduceWhitespaces().uppercase(),
                    incomeInvoicing = this.customer.incomeInvoicing,
                    addresses = this.customer.addresses.map { address ->
                        Onboarding.CustomerAddress(
                            purpose = address.purpose.uppercase()
                        )
                    }
                )
            )
        }
    }
}