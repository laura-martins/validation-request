package br.com.validation.request.validationRequest.util.annotation

import br.com.validation.request.validationRequest.util.validator.ExpirationDateValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [ExpirationDateValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidExpirationDate(
    val message: String = "Expiration date must be a valid date and not in the past",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
