import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main start")

    val defaultDeferred = async(Dispatchers.Default) {
        println("Default Dispatcher: Working on thread ${Thread.currentThread().name}")
        doWork()
    }

    println("Main waiting")

    // Await results
    val defaultResult = defaultDeferred.await()
    println("Result: $defaultResult")
    println("Main end")
}

suspend fun doWork(): Int {
    delay(1000L) // Simulating some work
    return 42
}
