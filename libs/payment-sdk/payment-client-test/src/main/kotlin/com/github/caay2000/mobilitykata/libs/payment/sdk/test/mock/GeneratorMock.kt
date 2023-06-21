package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mock

import com.github.caay2000.mobilitykata.libs.payment.sdk.Generator
import com.github.caay2000.mobilitykata.libs.payment.sdk.PaymentToken
import com.github.caay2000.mobilitykata.libs.payment.sdk.TransactionId
import com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother.PaymentTokenMother
import com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother.TransactionIdMother
import java.time.LocalDate

class GeneratorMock : Generator {

    private val paymentTokens = mutableListOf<PaymentToken>()
    private var paymentTokensIndex = 0

    fun mockPaymentToken(vararg tokens: PaymentToken) {
        paymentTokens.addAll(tokens)
    }

    override fun generatePaymentToken(): PaymentToken =
        paymentTokens.getOrElse(paymentTokensIndex) { PaymentTokenMother.random() }
            .also { paymentTokensIndex = paymentTokensIndex++ }

    private val transactionIds = mutableListOf<TransactionId>()
    private var transactionIdsIndex = 0

    fun mockTransactionId(vararg ids: TransactionId) {
        transactionIds.addAll(ids)
    }

    override fun generateTransactionId(): TransactionId =
        transactionIds.getOrElse(transactionIdsIndex) { TransactionIdMother.random() }
            .also { transactionIdsIndex = transactionIdsIndex++ }

    private val localDates = mutableListOf<LocalDate>()
    private var localDatesIndex = 0

    fun mockLocalDate(vararg dates: LocalDate) {
        localDates.addAll(dates)
    }

    override fun generateLocalDate(): LocalDate =
        localDates.getOrElse(localDatesIndex) { LocalDate.now() }
            .also { localDatesIndex = localDatesIndex++ }
}
