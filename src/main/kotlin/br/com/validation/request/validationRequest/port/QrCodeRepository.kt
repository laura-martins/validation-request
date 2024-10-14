package br.com.validation.request.validationRequest.port

import br.com.validation.request.validationRequest.entity.QrCodeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface QrCodeRepository : JpaRepository<QrCodeEntity, String>