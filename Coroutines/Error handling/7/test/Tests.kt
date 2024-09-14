import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertThrows
import org.junit.Test

class Test {
    @Test fun testSolution() = runTest {
        assertThrows(UnsupportedOperationException::class.java) {
            test()
        }
    }
}