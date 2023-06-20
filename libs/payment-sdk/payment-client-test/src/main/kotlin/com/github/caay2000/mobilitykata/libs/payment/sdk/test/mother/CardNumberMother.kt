package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother

import com.github.caay2000.mobilitykata.libs.payment.sdk.CardNumber
import kotlin.random.Random

object CardNumberMother {

    fun validCard(): CardNumber = CardNumber("${initialGroup()}${group(2)} ${group()} ${group()} ${validGroup()}")
    fun registerFailingCard(): CardNumber = CardNumber("${initialGroup()}${group(2)} ${group()} ${group()} ${registerFailGroup()}")
    fun onePaymentFailCard(): CardNumber = CardNumber("${initialGroup()}${group(2)} ${group()} ${group()} ${onePaymentFailGroup()}")
    fun allPaymentsFailCard(): CardNumber = CardNumber("${initialGroup()}${group(2)} ${group()} ${group()} ${allPaymentsFailGroup()}")

    private fun initialGroup(): String = "${Random.nextInt(40, 54)}"
    private fun group(size: Int = 4): String = "${List(size) { Random.nextInt(0, 9) }.joinToString(separator = "")}"

    private fun registerFailGroup(): String = "${group(1)}999"
    private fun onePaymentFailGroup(): String = "${group(2)}99"
    private fun allPaymentsFailGroup(): String = "${group(3)}9"
    private fun validGroup(): String = "${group(3)}${Random.nextInt(0, 8)}"
}
