package br.com.validation.request.validationRequest.controller

import br.com.validation.request.validationRequest.controller.mapper.domainToQrCodeResponse
import br.com.validation.request.validationRequest.controller.request.QrCodeRequest
import br.com.validation.request.validationRequest.controller.response.QrCodeResponse
import br.com.validation.request.validationRequest.usecase.CreateQrCodeUseCase
import br.com.validation.request.validationRequest.usecase.FindQrCodeUseCase
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@RequestMapping(value = ["/qrcodes"])
class QrCodeController (
    private val findQrCodeUseCase: FindQrCodeUseCase,
    private val createQrCodeUseCase: CreateQrCodeUseCase
) {

    @GetMapping(value = ["/{transactionId}"])
    fun consultaPorId(@PathVariable transactionId: String): ResponseEntity<QrCodeResponse> {
        val qrCode = findQrCodeUseCase.execute(transactionId)
        val response = qrCode.domainToQrCodeResponse()
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createQrCode(@Valid @RequestBody qrCodeRequest: QrCodeRequest): ResponseEntity<QrCodeResponse> {
        val response = createQrCodeUseCase.execute(qrCodeRequest.amount).domainToQrCodeResponse()
        return ResponseEntity.ok(response)
    }
}