package mobility.kata.libs.payment.sdk

import java.math.BigDecimal

data class PaymentRequest(
    val token: PaymentToken,
    val amount: PaymentAmount,
)

data class PaymentAmount(val value: BigDecimal) {

    init {
        if (value < BigDecimal("0.01")) {
            throw InvalidPaymentAmountException()
        }
    }

    override fun toString(): String = value.toPlainString()
}
