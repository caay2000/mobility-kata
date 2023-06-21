package com.github.caay2000.mobilitykata.libs.payment.sdk

interface PaymentClientApi {

    fun register(card: PaymentCard): PaymentToken

    fun pay(request: PaymentRequest): PaymentResult
}
