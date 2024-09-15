import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSolution() = runTest {
        var answer = 0
        launch { answer += 20 }
        launch { answer += 22 }
        runCurrent()
        assertEquals(42, answer)
    }
}