package br.com.validation.request.validationRequest.controller

import br.com.validation.request.validationRequest.controller.request.OnboardingRequest
import br.com.validation.request.validationRequest.controller.request.OnboardingRequest.Companion.convertToOnboarding
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/onboarding/seller"])
class OnboardingController {

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    fun createOnboarding(@Valid @RequestBody onboardingRequest: OnboardingRequest): String {
        print(onboardingRequest.convertToOnboarding())
        return "Deu certo"
    }
}