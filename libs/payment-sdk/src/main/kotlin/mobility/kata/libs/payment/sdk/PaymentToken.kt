package mobility.kata.libs.payment.sdk

data class PaymentToken(val value: String) {

    private val regex = Regex("^[0-9a-zA-Z]{24}\$")

    init {
        if (regex.matches(value).not()) {
            throw InvalidPaymentTokenException(this)
        }
    }

    override fun toString(): String = value
}
