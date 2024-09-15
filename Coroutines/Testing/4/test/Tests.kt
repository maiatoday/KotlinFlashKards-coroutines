import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds

class Test {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSolution() = runTest {
        var answer = 0
        launch { answer += 20 }
        launch { answer += 20 }
        launch {
            delay(2.seconds) // schedule for the future
            answer += 2
        }
        runCurrent()
        assertEquals(40, answer)
        advanceUntilIdle()
        assertEquals(42, answer)
    }
}