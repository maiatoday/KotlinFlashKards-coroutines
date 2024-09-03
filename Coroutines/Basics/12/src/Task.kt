import kotlinx.coroutines.*

fun main() = runBlocking {
    launch(Dispatchers.Default) {
        val data = fetchData()
        println(data)
    }

    println("Hello,")
}

suspend fun fetchData(): String =
    withContext(Dispatchers.IO) {
        println("...")
        // Simulating a long-running I/O operation
        delay(1000L)
        "World!"
    }