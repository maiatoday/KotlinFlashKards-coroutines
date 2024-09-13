import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun main() = runBlocking {
    try {
        val result = doSomething()
    } catch (e: TimeoutCancellationException) {
        println("Operation timed out with TimeoutCancellationException")
    }
}

suspend fun doSomething() {
    withTimeout(500.milliseconds) {
        // Simulate some work with delay
        delay(5.seconds)
        "Completed"
    }
}