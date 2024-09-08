import kotlinx.coroutines.*
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking {
    // Defining a CoroutineContext
    val coroutineContext: CoroutineContext =
        Dispatchers.Default +
                Job() +
                CoroutineName("MyCoroutine")

    // Launching a coroutine with the defined context
    val job = CoroutineScope(coroutineContext).launch {
        println("Running in context: ${coroutineContext[CoroutineName]?.name}")

        // Accessing individual context elements
        val dispatcher = coroutineContext[ContinuationInterceptor] as? CoroutineDispatcher
        val thisJob = coroutineContext[Job]

        println("Dispatcher: $dispatcher")
        println("Job: $thisJob")
    }

    job.join()  // Wait for the coroutine to complete
}
