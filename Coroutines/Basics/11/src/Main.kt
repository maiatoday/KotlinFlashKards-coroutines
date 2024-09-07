import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    // The UI related dispatcher is specific to UI frameworks e.g. Android
    launch {
        // Simulated workload on the main thread
        val result = loadData()
        println("Result: $result")
    }
}

suspend fun loadData(): String {
    delay(1000L) // Simulate an async operation
    return "Data Loaded"
}