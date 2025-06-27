package br.com.validation.request.validationRequest.controller.request.annotation

import br.com.validation.request.validationRequest.controller.request.validator.PixKeyValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [PixKeyValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidPixKey(
    val message: String = "Invalid Pix key",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)