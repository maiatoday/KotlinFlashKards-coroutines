import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertThrows
import org.junit.Test

class Test {

    @Test
    fun testSolution() {
        assertThrows(TimeoutCancellationException::class.java) {
            runTest {
                doSomething()
            }
        }
    }
}