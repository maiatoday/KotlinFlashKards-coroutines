import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.time.Duration.Companion.seconds

class Test {
    @Test fun testSolution() = runTest {
        delay(6.seconds)
        // Use both runTest and runBlocking and compare the timestamps in the Test results
        println("Did this take take 6 real seconds?")
        assert(true)
    }
}