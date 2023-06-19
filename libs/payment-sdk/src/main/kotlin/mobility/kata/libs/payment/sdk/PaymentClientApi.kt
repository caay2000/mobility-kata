package mobility.kata.libs.payment.sdk

interface PaymentClientApi {

    fun register(card: PaymentCard): PaymentToken

    fun pay(request: PaymentRequest): PaymentResult
}
