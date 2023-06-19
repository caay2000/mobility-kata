package mobility.kata.libs.payment.sdk

import java.util.UUID

data class PaymentResult(
    val transactionId: TransactionId,
    val result: TransactionResult,
)

data class TransactionId(val value: UUID) {
    override fun toString(): String = value.toString()
}

enum class TransactionResult { SUCCESS, FAILED }
