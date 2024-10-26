package br.com.validation.request.validationRequest.controller

import br.com.validation.request.validationRequest.controller.mapper.toQrCode
import br.com.validation.request.validationRequest.controller.mapper.toQrCodeResponse
import br.com.validation.request.validationRequest.controller.request.QrCodeRequest
import br.com.validation.request.validationRequest.controller.response.QrCodeResponse
import br.com.validation.request.validationRequest.usecase.CreateQrCodeUseCase
import br.com.validation.request.validationRequest.usecase.FindQrCodeUseCase
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/qrcodes"])
class QrCodeController (
    private val findQrCodeUseCase: FindQrCodeUseCase,
    private val createQrCodeUseCase: CreateQrCodeUseCase
) {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/{transactionId}"])
    fun consultaPorId(@PathVariable(required = true) @NotBlank transactionId: String): ResponseEntity<QrCodeResponse> {
        val qrCode = findQrCodeUseCase.execute(transactionId)
        val response = qrCode.toQrCodeResponse()
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createQrCode(@Valid @RequestBody qrCodeRequest: QrCodeRequest): ResponseEntity<QrCodeResponse> {
        val qrCode = qrCodeRequest.toQrCode()
        val response = createQrCodeUseCase.execute(qrCode).toQrCodeResponse()
        return ResponseEntity.ok(response)
    }
}