import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    val job = launch {
        repeat(100) { i ->
            delay(100.milliseconds)
            println("Coroutine is working on iteration $i")
        }
    }

    delay(500.milliseconds) // Let the coroutine run for a bit
    println("Main thread cancels the coroutine")
    job.cancelAndJoin() // Cancel the coroutine and wait for its completion
    println("Coroutine has been cancelled")
    check(job.isCancelled)
}