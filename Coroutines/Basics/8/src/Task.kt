import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    val job = launch {
        // Simulated workload
        repeat(5) { i ->
            println("Coroutine working on task $i ...")
            delay(100.milliseconds) // Simulate a delay of 500ms
        }
    }

    // This line will be printed immediately
    println("main: I'm waiting, but won't block the thread.")
    check(job.isActive)

    // Wait for the job to complete
    job.join()

    // This line will be printed after the coroutine has completed
    println("main: Now I can continue.")
    check(job.isCompleted)
}