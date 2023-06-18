package mobility.kata.libs.payment.sdk

sealed class PaymentClientException(override val message: String) : RuntimeException(message)

data class InvalidCardNumberException(val cardNumber: String) :
    PaymentClientException("Invalid cardNumber [$cardNumber]")

data class InvalidCardMonthException(val cardMonth: String) :
    PaymentClientException("Invalid cardMonth [$cardMonth]")

data class InvalidCardYearException(val cardYear: String) :
    PaymentClientException("Invalid cardYear [$cardYear]")

data class InvalidCardCVCException(val cardCVC: String) :
    PaymentClientException("Invalid cardCVC [$cardCVC]")

data class InvalidCardHolderNameException(val cardHolderName: String) :
    PaymentClientException("Invalid cardHolderName [$cardHolderName]")
