import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {
    // Creating a parent job
    val parentJob = Job()

    // Launching a child coroutine
    val childJob = launch(parentJob) {
        delay(1.seconds)
        println("Child coroutine completed")
    }

    // Launching a deferred child coroutine
    val childJobDeferred = async(parentJob) {
        delay(1.seconds)
        println("Child coroutine completed (deferred)")
        "Deferred"
    }

    // Displaying relationship
    println("Parent job: $parentJob")
    println("Child 1 job: $childJob")
    println("Child 2 job (deferred): $childJobDeferred")

    // Showing children
    println("Children of parent job: ${parentJob.children.toList()}")

    // Showing parent
    println("Parent of child 1 job: ${childJob.parent}")
    println("Parent of child 2 job (deferred): ${childJobDeferred.parent}")

    // Waiting for child completion
    childJobDeferred.await()
    childJob.join()
}