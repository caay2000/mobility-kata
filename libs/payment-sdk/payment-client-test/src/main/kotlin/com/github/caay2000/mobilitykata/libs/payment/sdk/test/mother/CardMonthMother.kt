package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother

import com.github.caay2000.mobilitykata.libs.payment.sdk.CardMonth

object CardMonthMother {

    private val months = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")

    fun random(): CardMonth = CardMonth(months.random())
}
