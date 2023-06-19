package mobility.kata.libs.payment.sdk.test.mother

import mobility.kata.libs.payment.sdk.TransactionId
import java.util.UUID

object TransactionIdMother {

    fun random(value: UUID = UUID.randomUUID()) = TransactionId(value)
}
