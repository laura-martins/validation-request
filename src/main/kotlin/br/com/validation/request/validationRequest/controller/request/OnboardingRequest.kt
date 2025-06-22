package br.com.validation.request.validationRequest.controller.request

import br.com.validation.request.validationRequest.controller.request.validator.PatternRegex
import br.com.validation.request.validationRequest.controller.request.validator.normalizeAndRemoveAllWhitespaces
import br.com.validation.request.validationRequest.controller.request.validator.normalizeAndTrimWhitespaces
import br.com.validation.request.validationRequest.domain.Onboarding
import jakarta.validation.Valid
import jakarta.validation.constraints.*

data class OnboardingRequest (

    @field:[NotBlank Pattern(regexp = PatternRegex.UUID_VALID)]
    val customerId: String,

    @field:[Size(min = 1, max = 1) Valid]
    val destinationAccoutns: List<DestinationAccount>?,

    @field:[NotNull Valid]
    val customer: Customer
) {
    data class DestinationAccount(
        @field:[NotBlank]
        val key: String,

        @field:[NotNull Min(100) Max(100)]
        val percent: Int,
    )

    data class Customer(
        @field:[NotBlank Pattern(regexp = PatternRegex.CNPJ_VALID)]
        val documentNumber: String,

        @field:[NotBlank Size(min = 2, max = 60)]
        val name: String,

        @field:[NotNull Min(1)]
        val incomeInvoicing: Int
    )

    companion object {
        fun OnboardingRequest.convertToOnboarding(): Onboarding {
            return Onboarding(
                customerId = this.customerId.normalizeAndTrimWhitespaces(),
                destinationAccoutns = this.destinationAccoutns?.map {
                    Onboarding.DestinationAccount(
                        key = it.key.normalizeAndRemoveAllWhitespaces(),
                        percent = it.percent
                    )
                },
                customer = Onboarding.Customer(
                    documentNumber = this.customer.documentNumber.normalizeAndRemoveAllWhitespaces(),
                    name = this.customer.name.normalizeAndTrimWhitespaces(),
                    incomeInvoicing = this.customer.incomeInvoicing
                )
            )
        }
    }
}