import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000L) // Non-blocking delay for 1 second
        println("World!")
    }

    println("Hello,")
}