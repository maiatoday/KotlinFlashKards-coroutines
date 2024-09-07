import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.yield
import java.util.concurrent.atomic.AtomicInteger

val testMutex = Mutex()
var testSharedCounter1 = 0
var testSharedCounter2: AtomicInteger = AtomicInteger(0)
var testSharedCounterUnsafe = 0

suspend fun testSafeIncrement1() {
    testMutex.withLock {
        testSharedCounter1++
    }
}

suspend fun testSafeIncrement2() {
    yield()
    testSharedCounter2.getAndIncrement()
}

suspend fun unsafeIncrement() {
    yield()
    testSharedCounterUnsafe++
}

fun main() = runBlocking {
    val jobs = List(100) {
        launch(Dispatchers.Default) {
            repeat(1000) {
                testSafeIncrement1()
                testSafeIncrement2()
                unsafeIncrement()
            }
        }
    }
    jobs.forEach { it.join() }
    // Check if the counter is correct
    check(100000 == testSharedCounter1, { "Counter1 should be 100,000" })
    println("Mutex Test passed: Counter = $testSharedCounter1")
    check(100000 == testSharedCounter2.get(), { "Counter2 should be 100,000" })
    println("Atomic Test passed: Counter = ${testSharedCounter2.get()}")
    println("Unsafe Counter = $testSharedCounterUnsafe")
    check(100000 != testSharedCounterUnsafe, { "Unsafe Counter has a small chance of being correct" })
}
