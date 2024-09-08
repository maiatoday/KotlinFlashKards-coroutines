import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

fun main() = runBlocking {
    // Launch a coroutine scope
    val job = launch {
        // Child task 1
        val child1 = launch {
            // Simulate a task that takes 2 seconds to complete
            delay(2.seconds)
            println("Result of child 1: ${1 + 1}")
        }

        // Child task 2
        val child2 = launch {
            // Simulate a task that takes 1 second to complete
            delay(1.seconds)
            println("Result of child 2: Hello, World!")
        }

        // Wait for both tasks to complete
        println("Waiting for children to complete...")
        child1.join()
        child2.join()
    }

    // Wait for the entire job to finish
    job.join()
    println("Parent can complete only after children complete.")
    // If you remove the job.join() then it will wait here for the children to complete
}
