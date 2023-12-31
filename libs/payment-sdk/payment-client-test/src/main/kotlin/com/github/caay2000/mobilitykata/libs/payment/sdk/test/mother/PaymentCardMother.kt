package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother

import com.github.caay2000.mobilitykata.libs.payment.sdk.CardCVC
import com.github.caay2000.mobilitykata.libs.payment.sdk.CardHolderName
import com.github.caay2000.mobilitykata.libs.payment.sdk.CardMonth
import com.github.caay2000.mobilitykata.libs.payment.sdk.CardNumber
import com.github.caay2000.mobilitykata.libs.payment.sdk.CardYear
import com.github.caay2000.mobilitykata.libs.payment.sdk.PaymentCard

object PaymentCardMother {

    private fun random(
        cardNumber: CardNumber = CardNumberMother.validCard(),
        month: CardMonth = CardMonthMother.random(),
        year: CardYear = CardYearMother.nonExpired(),
        cvc: CardCVC = CardCVCMother.random(),
        holder: CardHolderName = CardHolderNameMother.random(),
    ): PaymentCard = PaymentCard(
        cardNumber = cardNumber,
        month = month,
        year = year,
        cvc = cvc,
        holder = holder,
    )

    fun valid(): PaymentCard = random()

    fun registerFail(): PaymentCard = random(cardNumber = CardNumberMother.registerFailingCard())
    fun oneFailureCard(): PaymentCard = random(cardNumber = CardNumberMother.onePaymentFailCard())
    fun alwaysFailingCard(): PaymentCard = random(cardNumber = CardNumberMother.allPaymentsFailCard())

    fun expiredCard(): PaymentCard = random(year = CardYearMother.expired())
}
