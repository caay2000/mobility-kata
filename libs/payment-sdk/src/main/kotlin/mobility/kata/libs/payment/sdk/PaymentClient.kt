package mobility.kata.libs.payment.sdk

interface PaymentClient {

    fun registerPaymentMethod(card: PaymentCard): PaymentToken
}
