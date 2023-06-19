package mobility.kata.libs.payment.sdk.test.mother

import mobility.kata.libs.payment.sdk.CardHolderName

object CardHolderNameMother {

    fun random(): CardHolderName =
        CardHolderName(
            RandomStringGenerator.randomName()
                .take(40)
                .replace(".", " "),
        )
}
