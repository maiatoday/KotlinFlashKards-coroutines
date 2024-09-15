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
            answer += 2
        }
        advanceTimeBy(2.seconds)
        println("the time is $currentTime")
        assertEquals(40, answer)
        advanceTimeBy(1.milliseconds)
        println("the time is $currentTime")
        assertEquals(42, answer)
    }
}