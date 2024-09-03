import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runTest {
        val result = hello()
        assertEquals("Hello World!", result)
    }
}