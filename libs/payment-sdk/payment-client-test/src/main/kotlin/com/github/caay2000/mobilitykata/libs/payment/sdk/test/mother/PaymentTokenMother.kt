package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother

import com.github.caay2000.mobilitykata.libs.payment.sdk.PaymentToken

object PaymentTokenMother {

    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun random(): PaymentToken = PaymentToken(List(24) { charPool.random() }.joinToString(separator = ""))
}
