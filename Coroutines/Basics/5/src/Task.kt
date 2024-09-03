import kotlinx.coroutines.*

fun main() = runBlocking {
    val result = twoWorkers()
    println("Result: $result")
}

suspend fun twoWorkers(): Int = coroutineScope {
    val deferred1 = async { doWorkOne() }
    val deferred2 = async { doWorkTwo() }
    deferred1.await() + deferred2.await()
}

suspend fun doWorkOne(): Int {
    delay(100L) // Simulating some work
    println("Work one completed")
    return 10
}

suspend fun doWorkTwo(): Int {
    delay(100L) // Simulating some work
    println("Work two completed")
    return 5
}