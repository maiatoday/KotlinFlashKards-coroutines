import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {

    withContext(CoroutineName("Parent Coroutine")) {
        coroutineScope {
            // Child task 1
           launch {
                // Simulate a task that takes 2 seconds to complete
                delay(100.milliseconds)
                println("Result of child 1: ${1 + 1}")
                println("Name from child 1 inherited from parent ${coroutineContext[CoroutineName]?.name}")
            }

            // Child task 2
            launch {
                // Simulate a task that takes 1 second to complete
                delay(100.milliseconds)
                println("Result of child 2: Hello, World!")
                println("Name from child 2 inherited from parent ${coroutineContext[CoroutineName]?.name}")
            }

            // Wait for both tasks to complete
            println("Name from coroutineScope ${coroutineContext[CoroutineName]?.name}")
        }
        println("Name from outerScope ${coroutineContext[CoroutineName]?.name}")
    }
}
