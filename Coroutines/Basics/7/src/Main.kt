import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main start")

    val deferred = async(Dispatchers.IO) {
        println("Dispatcher: Working on thread ${Thread.currentThread().name}")
        doWork()
    }

    println("Main waiting")

    // Await results
    val result = deferred.await()
    println("Result: $result")
    println("Main end")
}

suspend fun doWork(): Int {
    delay(1000L) // Simulating some work
    return 42
}
