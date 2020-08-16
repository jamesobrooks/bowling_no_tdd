import Exceptions.TooFewRollsException
import Exceptions.TooManyRollsException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ScoreKtTest {
    @Test
    fun scorePerfect() {
        for (i in 1..12) {
            roll(10)
        }
        assertEquals(300, score())
    }

    @Test
    fun scoreAllOnes() {
        for (i in 1..20) {
            roll(1)
        }
        assertEquals(20, score())
    }

    @Test
    fun scoreGutterGame() {
        for (i in 1..20) {
            roll(0)
        }
        assertEquals(0, score())
    }

    @Test
    fun score168() {
        roll168()
        assertEquals(168, score())
    }

    @Test
    fun score13Strikes() {
        for (i in 1..13) {
            roll(10)
        }
        assertThrows(TooManyRollsException::class.java, {score()})
    }

    @Test
    fun score22Ones() {
        for (i in 1..22) {
            roll(1)
        }
        assertThrows(TooManyRollsException::class.java, {score()})
    }

    @Test
    fun score11Strikes() {
        for (i in 1..11) {
            roll(10)
        }
        assertThrows(TooFewRollsException::class.java, {score()})
    }

    @Test
    fun score19Ones() {
        for (i in 1..19) {
            roll(1)
        }
        assertThrows(TooFewRollsException::class.java, {score()})
    }
}
