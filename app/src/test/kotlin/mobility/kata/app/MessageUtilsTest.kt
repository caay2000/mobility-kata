/*
 * This Kotlin source file was generated by the Gradle "init" task.
 */
package mobility.kata.app

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MessageUtilsTest {
    @Test
    fun testGetMessage() {
        assertEquals("Hello      World!", MessageUtils.getMessage())
    }
}