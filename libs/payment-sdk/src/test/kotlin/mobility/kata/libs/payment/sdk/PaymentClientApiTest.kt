package mobility.kata.libs.payment.sdk

import mobility.kata.libs.payment.sdk.test.mock.GeneratorMock
import mobility.kata.libs.payment.sdk.test.mother.PaymentCardMother
import mobility.kata.libs.payment.sdk.test.mother.PaymentTokenMother
import mobility.kata.libs.payment.sdk.test.mother.TransactionIdMother
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate

class PaymentClientApiTest {

    @Test
    fun `should fail on register with an invalid card number`() {
        val sut = PaymentClientInternal(GeneratorMock())

        val paymentCard = PaymentCardMother.registerFail()

        Assertions.assertThatThrownBy { sut.register(paymentCard) }
            .hasMessage("Card cannot be registered, invalid card number [${paymentCard.cardNumber.ofuscated}]")
            .isInstanceOf(InvalidCardNumberRegistrationException::class.java)
    }

    @Test
    fun `should fail on register with an expired card`() {
        val mock = GeneratorMock()
        val sut = PaymentClientInternal(mock)

        mock.mockLocalDate(LocalDate.of(2024, 1, 1))
        val paymentCard = PaymentCardMother.expiredCard()

        Assertions.assertThatThrownBy { sut.register(paymentCard) }
            .hasMessage("Card cannot be registered, expired card [${paymentCard.month}/${paymentCard.year}]")
            .isInstanceOf(ExpiredPaymentCardRegistrationException::class.java)
    }

    @Test
    fun `should return valid token on valid card`() {
        val mock = GeneratorMock()
        val sut = PaymentClientInternal(mock)

        val expectedPaymentToken = PaymentTokenMother.random()
        mock.mockPaymentToken(expectedPaymentToken)

        val result = sut.register(PaymentCardMother.valid())
        assertThat(result).isEqualTo(expectedPaymentToken)
    }

    @Test
    fun `should fail on not registered card`() {
        val sut = PaymentClientInternal(GeneratorMock())

        val paymentToken = PaymentTokenMother.random()

        Assertions.assertThatThrownBy { sut.pay(PaymentRequest(token = paymentToken, amount = PaymentAmount(BigDecimal.TEN))) }
            .hasMessage("Payment Token is not registered [$paymentToken]")
            .isInstanceOf(PaymentTokenNotRegisteredException::class.java)
    }

    @Test
    fun `should fail when paying with a not registered card`() {
        val sut = PaymentClientInternal(GeneratorMock())

        val paymentToken = PaymentTokenMother.random()

        Assertions.assertThatThrownBy { sut.pay(PaymentRequest(token = paymentToken, amount = PaymentAmount(BigDecimal.TEN))) }
            .hasMessage("Payment Token is not registered [$paymentToken]")
            .isInstanceOf(PaymentTokenNotRegisteredException::class.java)
    }

    @Test
    fun `should fail on a always failing card`() {
        val mock = GeneratorMock()
        val sut = PaymentClientInternal(mock)

        val paymentToken = sut.register(PaymentCardMother.alwaysFailingCard())

        repeat(11) {
            val result = sut.pay(PaymentRequest(token = paymentToken, amount = PaymentAmount(BigDecimal.TEN)))
            assertThat(result.result).isEqualTo(TransactionResult.FAILED)
        }
    }

    @Test
    fun `should fail first and each 10 time with a one time failing card`() {
        val mock = GeneratorMock()
        val sut = PaymentClientInternal(mock)

        val paymentToken = sut.register(PaymentCardMother.oneFailureCard())

        repeat(15) {
            val result = sut.pay(PaymentRequest(token = paymentToken, amount = PaymentAmount(BigDecimal.TEN)))
            if (it == 0 || it == 10) {
                assertThat(result.result).isEqualTo(TransactionResult.FAILED)
            } else assertThat(result.result).isEqualTo(TransactionResult.SUCCESS)
        }
    }

    @Test
    fun `should succeed with each call`() {
        val mock = GeneratorMock()
        val sut = PaymentClientInternal(mock)

        val transactionId = TransactionIdMother.random()
        mock.mockTransactionId(transactionId)
        val paymentToken = sut.register(PaymentCardMother.valid())

        val result = sut.pay(PaymentRequest(token = paymentToken, amount = PaymentAmount(BigDecimal.TEN)))
        assertThat(result).isEqualTo(PaymentResult(transactionId = transactionId, result = TransactionResult.SUCCESS))
    }
}
