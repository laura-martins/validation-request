package br.com.validation.request.validationRequest.controller

import br.com.validation.request.validationRequest.controller.mapper.toQrCode
import br.com.validation.request.validationRequest.controller.request.QrCodeRequest
import br.com.validation.request.validationRequest.usecase.CreateQrCodeUseCase
import br.com.validation.request.validationRequest.usecase.FindQrCodeUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class QrCodeControllerTest {

    @InjectMocks
    private lateinit var qrCodeController: QrCodeController

    @Mock
    private lateinit var findQrCodeUseCase: FindQrCodeUseCase

    @Mock
    private lateinit var createQrCodeUseCase: CreateQrCodeUseCase

    @Test
    fun consultaPorIdThrowsExceptionWhenTransactionIdIsInvalid() {
        val transactionId = "invalidTransactionId"

        `when`(findQrCodeUseCase.execute(transactionId)).thenThrow(IllegalArgumentException("Invalid transaction ID"))

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            qrCodeController.consultaPorId(transactionId)
        }

        assertEquals("Invalid transaction ID", exception.message)
    }

    @Test
    fun createQrCodeThrowsExceptionWhenRequestIsInvalid() {
        val qrCodeRequest = mock(QrCodeRequest::class.java)

        `when`(qrCodeRequest.toQrCode()).thenThrow(IllegalArgumentException("Invalid request"))

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            qrCodeController.createQrCode(qrCodeRequest)
        }

        assertEquals("Invalid request", exception.message)
    }
}