import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

val testMutex = Mutex()
var testSharedCounter = 0

suspend fun testSafeIncrement() {
    testMutex.withLock {
        testSharedCounter++
    }
}

fun main() = runBlocking {
    val jobs = List(100) {
        launch(Dispatchers.Default) {
            repeat(1000) {
                testSafeIncrement()
            }
        }
    }
    jobs.forEach { it.join() }
    // Check if the counter is correct
    check(100000==testSharedCounter)//, //"Counter should be 100,000")
    println("Test passed: Counter = $testSharedCounter")
}
