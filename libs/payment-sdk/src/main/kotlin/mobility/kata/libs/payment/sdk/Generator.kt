package mobility.kata.libs.payment.sdk

import java.time.LocalDate

interface Generator {

    fun generatePaymentToken(): PaymentToken

    fun generateTransactionId(): TransactionId

    fun generateLocalDate(): LocalDate
}
