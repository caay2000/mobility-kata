package mobility.kata.libs.payment.sdk

import java.time.LocalDate
import java.util.UUID

class PaymentClient : PaymentClientApi by PaymentClientInternal(DefaultGenerator()) {

    private class DefaultGenerator : Generator {

        private val paymentTokenCharPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        override fun generatePaymentToken(): PaymentToken = PaymentToken(List(24) { paymentTokenCharPool.random() }.joinToString(separator = ""))
        override fun generateTransactionId(): TransactionId = TransactionId((UUID.randomUUID()))
        override fun generateLocalDate(): LocalDate = LocalDate.now()
    }
}

internal class PaymentClientInternal(private val generator: Generator) : PaymentClientApi {

    private val registeredTokens = mutableMapOf<PaymentToken, PaymentCard>()
    private val failedPayments = mutableMapOf<PaymentToken, Int>()

    override fun register(card: PaymentCard): PaymentToken {
        if (card.registerIsFailing()) throw InvalidCardNumberRegistrationException(card)
        if (card.isExpired()) throw ExpiredPaymentCardRegistrationException(card)

        val paymentToken = generator.generatePaymentToken()
        registeredTokens[paymentToken] = card
        return paymentToken
    }

    override fun pay(request: PaymentRequest): PaymentResult {
        if (registeredTokens.keys.none { it == request.token }) throw PaymentTokenNotRegisteredException(request.token)

        return if (request.shouldFail()) {
            PaymentResult(generator.generateTransactionId(), TransactionResult.FAILED)
        } else {
            PaymentResult(generator.generateTransactionId(), TransactionResult.SUCCESS)
        }
    }

    private fun PaymentCard.registerIsFailing(): Boolean = cardNumber.value.endsWith("999")
    private fun PaymentCard.onePaymentIsFailing(): Boolean = cardNumber.value.endsWith("99")
    private fun PaymentCard.allPaymentsAreMissing(): Boolean = cardNumber.value.endsWith("9")
    private fun PaymentCard.isExpired(): Boolean {
        val cardDate = LocalDate.of(year.value.toInt(), month.value.toInt(), 1)
            .plusMonths(1).minusDays(1)
        return cardDate.isBefore(generator.generateLocalDate())
    }

    private fun PaymentRequest.shouldFail(): Boolean {
        val card = registeredTokens[token]!!
        return when {
            card.onePaymentIsFailing() -> onePaymentBehaviour()
            card.allPaymentsAreMissing() -> true
            else -> false
        }
    }

    private fun PaymentRequest.onePaymentBehaviour(): Boolean =
        when {
            failedPayments.containsKey(token).not() -> failAndStartPayments()
            failedPayments[token]!! == 10 -> failAndResetPayments()
            else -> doNotFailAndIncreasePayments()
        }

    private fun PaymentRequest.failAndStartPayments(): Boolean {
        failedPayments[token] = 1
        return true
    }

    private fun PaymentRequest.failAndResetPayments(): Boolean {
        failedPayments[token] = 0
        return true
    }

    private fun PaymentRequest.doNotFailAndIncreasePayments(): Boolean {
        failedPayments[token] = failedPayments[token]!! + 1
        return false
    }
}
