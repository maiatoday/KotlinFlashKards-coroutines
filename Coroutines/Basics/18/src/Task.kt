import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking {
    // Defining a CoroutineContext
    val coroutineContext: CoroutineContext =
        Dispatchers.Default + CoroutineName("MyCoroutine")

    // Launching a coroutine with the defined context
    val job = CoroutineScope(coroutineContext).launch {
        println("Running in context: ${coroutineContext[CoroutineName]?.name}")
    }

    job.join()  // Wait for the coroutine to complete
}
