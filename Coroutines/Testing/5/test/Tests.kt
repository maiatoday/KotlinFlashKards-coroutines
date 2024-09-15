import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class Test {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSolution() = runTest {
        var answer = 40
        launch {
            delay(2.seconds) // schedule for the future
            answer += 1
        }
        launch {
            delay(4.seconds) // schedule for the future
            answer += 1
        }
        advanceTimeBy(2.seconds)
        println("current time is $currentTime")
        assertEquals(40, answer)
        advanceTimeBy(1.milliseconds)
        println("current time is $currentTime")
        assertEquals(41, answer)
        advanceTimeBy(2.seconds)
        println("current time is $currentTime")
        assertEquals(42, answer)
    }
}