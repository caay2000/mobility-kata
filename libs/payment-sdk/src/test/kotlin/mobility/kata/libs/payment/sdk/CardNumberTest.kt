package mobility.kata.libs.payment.sdk

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CardNumberTest {

    @ParameterizedTest(name = "invalid card number for {0}")
    @ValueSource(strings = [" ", "whatever", "4321123456789012", "5621 1234 5678 9012"])
    fun `invalid card number throws exception`(value: String) {
        assertThatThrownBy { CardNumber(value) }
            .hasMessage("Invalid cardNumber [$value]")
            .isInstanceOf(InvalidCardNumberException::class.java)
    }

    @ParameterizedTest(name = "valid card number for VISA or MASTERCARD {0}")
    @ValueSource(strings = ["4321 1234 5678 9012", "5123 4567 8901 2345", "5523 4567 8901 2345"])
    fun `valid card number`(value: String) {
        CardNumber(value)
    }

    @ParameterizedTest(name = "invalid card month for {0}")
    @ValueSource(strings = ["January", "1", "13", "00", ""])
    fun `invalid card month throws exception`(value: String) {
        assertThatThrownBy { CardMonth(value) }
            .hasMessage("Invalid cardMonth [$value]")
            .isInstanceOf(InvalidCardMonthException::class.java)
    }

    @ParameterizedTest(name = "valid card month {0}")
    @ValueSource(strings = ["01", "09", "10", "12"])
    fun `valid card month`(value: String) {
        CardMonth(value)
    }

    @ParameterizedTest(name = "invalid card year for {0}")
    @ValueSource(strings = ["2019", "2040", "year", ""])
    fun `invalid card year throws exception`(value: String) {
        assertThatThrownBy { CardYear(value) }
            .hasMessage("Invalid cardYear [$value]")
            .isInstanceOf(InvalidCardYearException::class.java)
    }

    @ParameterizedTest(name = "valid card year {0}")
    @ValueSource(strings = ["2020", "2039"])
    fun `valid card year`(value: String) {
        CardYear(value)
    }

    @ParameterizedTest(name = "invalid card cvc for {0}")
    @ValueSource(strings = ["CVC", "cvc", "12a", ""])
    fun `invalid card cvc throws exception`(value: String) {
        assertThatThrownBy { CardCVC(value) }
            .hasMessage("Invalid cardCVC [$value]")
            .isInstanceOf(InvalidCardCVCException::class.java)
    }

    @ParameterizedTest(name = "valid card cvc {0}")
    @ValueSource(strings = ["000", "123", "687", "999"])
    fun `valid card cvc`(value: String) {
        CardCVC(value)
    }

    @ParameterizedTest(name = "invalid card holder Name for {0}")
    @ValueSource(strings = ["", " ", "anything with numbers 2", "more than 40 chars should throw an except"])
    fun `invalid card holder Name throws exception`(value: String) {
        assertThatThrownBy { CardHolderName(value) }
            .hasMessage("Invalid cardHolderName [$value]")
            .isInstanceOf(InvalidCardHolderNameException::class.java)
    }

    @ParameterizedTest(name = "valid card holder Name {0}")
    @ValueSource(strings = ["Any length from two to forty", "spaces included"])
    fun `valid card holder Name`(value: String) {
        CardHolderName(value)
    }
}
