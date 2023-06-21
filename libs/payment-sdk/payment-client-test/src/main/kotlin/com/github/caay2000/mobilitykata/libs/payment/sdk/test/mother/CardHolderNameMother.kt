package com.github.caay2000.mobilitykata.libs.payment.sdk.test.mother

import com.github.caay2000.mobilitykata.libs.payment.sdk.CardHolderName

object CardHolderNameMother {

    fun random(): CardHolderName =
        CardHolderName(
            RandomStringGenerator.randomName()
                .take(40)
                .replace(".", " "),
        )
}
