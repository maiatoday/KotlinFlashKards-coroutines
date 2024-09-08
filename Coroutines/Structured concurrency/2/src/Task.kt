import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

fun main() = runBlocking {
    coroutineScope {
        // Define and launch concurrent tasks within this scope
        val job1 = launch {
            // Simulate a task that takes 1 second to complete
            delay(1.seconds)
            println("Task 1 complete")
        }

        val job2 = launch {
            // Simulate a task that takes 2 seconds to complete
            delay(2.seconds)
            println("Task 2 complete")
        }

        // Both tasks are running concurrently
        println("Tasks are launched")
    }
    // Out of the coroutineScope block, all tasks are guaranteed to be complete
    println("All tasks are complete")
}