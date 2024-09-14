import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.time.Duration.Companion.milliseconds

class Test {
    @Test fun testSolution() = runTest {
        delay(100.milliseconds)
        assert(true)
    }
}