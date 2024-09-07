import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runTest {
        val result = fetchData()
        assertEquals("World!", result)
    }
}