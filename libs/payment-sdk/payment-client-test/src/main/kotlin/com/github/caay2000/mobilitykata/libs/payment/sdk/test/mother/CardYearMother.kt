package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother

import com.github.caay2000.mobilitykata.libs.payment.sdk.CardYear
import java.time.LocalDate
import kotlin.random.Random

object CardYearMother {

    fun nonExpired(): CardYear = CardYear(Random.nextInt(LocalDate.now().year + 1, 2069).toString())
    fun expired(): CardYear = CardYear(Random.nextInt(2020, LocalDate.now().year - 1).toString())
}
