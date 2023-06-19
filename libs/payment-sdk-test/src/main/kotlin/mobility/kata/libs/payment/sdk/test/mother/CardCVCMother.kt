package mobility.kata.libs.payment.sdk.test.mother

import mobility.kata.libs.payment.sdk.CardCVC
import kotlin.random.Random

object CardCVCMother {
    fun random(): CardCVC = CardCVC("${randomDigit()}${randomDigit()}${randomDigit()}")

    private fun randomDigit() = Random.nextInt(0, 9).toString()
}
