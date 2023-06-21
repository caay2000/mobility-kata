package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother

import com.github.caay2000.mobilitykata.libs.payment.sdk.TransactionId
import java.util.UUID

object TransactionIdMother {

    fun random(value: UUID = UUID.randomUUID()) = TransactionId(value)
}
