import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun main() = runBlocking {
    val result = withTimeoutOrNull(500.milliseconds) {
        // Simulate some work with delay
        delay(5.seconds)
        "Completed"
    }

    if (result == null) {
        println("Operation timed out and returned null.")
    } else {
        println("Operation completed successfully: $result")
    }
    check(result == null)
}