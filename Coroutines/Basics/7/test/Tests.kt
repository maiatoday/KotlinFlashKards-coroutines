import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.milliseconds

class JobTest {

    @Test
    fun testSolution() = runTest {
        val handleToCoroutine: Job = launch {
            // Simulated workload
            repeat(1000) { i ->
                println("I'm working on task $i ...")
                delay(500.milliseconds)
            }
        }

        // Ensure the job is active before cancellation
        assertTrue(handleToCoroutine.isActive)

        // Cancel the job and wait for its completion
        handleToCoroutine.cancelAndJoin()

        // Ensure the job is no longer active
        assertFalse(handleToCoroutine.isActive)
        assertTrue(handleToCoroutine.isCancelled)
    }
}