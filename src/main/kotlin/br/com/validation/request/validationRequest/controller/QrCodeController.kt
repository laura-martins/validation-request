package br.com.validation.request.validationRequest.controller

import br.com.validation.request.validationRequest.controller.mapper.domainToQrCodeResponse
import br.com.validation.request.validationRequest.controller.response.QrCodeResponse
import br.com.validation.request.validationRequest.usecase.FindQrCodeUseCase
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping(value = ["/qrcodes"])
class QrCodeController (
    private val findQrCodeUseCase: FindQrCodeUseCase
) {

    @GetMapping(value = ["/{transactionId}"])
    fun consultaPorId(@PathVariable transactionId: String): ResponseEntity<QrCodeResponse> {
        val qrCode = findQrCodeUseCase.execute(transactionId)
        val response = qrCode.domainToQrCodeResponse()
        return ResponseEntity.ok(response)
    }
}