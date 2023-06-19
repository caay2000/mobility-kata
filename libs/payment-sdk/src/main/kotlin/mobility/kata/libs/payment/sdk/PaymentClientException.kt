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

class InvalidPaymentAmountException : PaymentClientException("Invalid paymentAmount. It cannot be less than 0,01")

data class InvalidCardNumberRegistrationException(val card: PaymentCard) :
    PaymentClientException("Card cannot be registered, invalid card number [${card.cardNumber}]")

data class ExpiredPaymentCardRegistrationException(val card: PaymentCard) :
    PaymentClientException("Card cannot be registered, expired card [${card.month}/${card.year}]")

data class InvalidPaymentTokenException(val paymentToken: PaymentToken) :
    PaymentClientException("Invalid Payment Token [$paymentToken]")

data class PaymentTokenNotRegisteredException(val paymentToken: PaymentToken) :
    PaymentClientException("Payment Token is not registered [$paymentToken]")
