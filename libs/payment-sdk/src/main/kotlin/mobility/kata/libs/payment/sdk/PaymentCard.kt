package mobility.kata.libs.payment.sdk

data class PaymentCard(
    val cardNumber: CardNumber,
    val month: CardMonth,
    val year: CardYear,
    val cvc: CardCVC,
    val holder: CardHolderName,
)

data class CardNumber(val value: String) {

    private val regex = Regex("(^4[0-9]{3} [0-9]{4} [0-9]{4} [0-9]{4})|(^5[1-5][0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4})\$")

    init {
        if (regex.matches(value).not()) {
            throw InvalidCardNumberException(value)
        }
    }

    override fun toString(): String = value
}

data class CardMonth(val value: String) {

    private val regex = Regex("(^0[1-9])|(^1[0-2])\$")

    init {
        if (regex.matches(value).not()) {
            throw InvalidCardMonthException(value)
        }
    }

    override fun toString(): String = value
}
data class CardYear(val value: String) {
    private val regex = Regex("^20(2[0-9]|3[0-9])\$")

    init {
        if (regex.matches(value).not()) {
            throw InvalidCardYearException(value)
        }
    }

    override fun toString(): String = value
}
data class CardCVC(val value: String) {
    private val regex = Regex("^[0-9]{3}\$")

    init {
        if (regex.matches(value).not()) {
            throw InvalidCardCVCException(value)
        }
    }

    override fun toString(): String = value
}

data class CardHolderName(val value: String) {
    private val regex = Regex("^[a-z|A-Z| ]{2,40}\$")

    init {
        if (regex.matches(value).not()) {
            throw InvalidCardHolderNameException(value)
        }
    }

    override fun toString(): String = value
}
