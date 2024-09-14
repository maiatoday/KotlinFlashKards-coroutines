import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main():Unit = runBlocking {
    launch {
        val ticks = async {
            // Child 1 ticks
            var ticks = 0
            repeat (10) {
                println("Tick")
                ticks++
                delay(100.milliseconds)
            }
            ticks
        }
        launch {
            // Child 2 stops the clock
            delay(500.milliseconds)
            // stop the ticking in the sibling and stop the main thread
            throw StopTheClockException("Child 2 Stop!")
        }
        println("Ticks ${ticks.await()}")
        println("End")
    }
}

class StopTheClockException(message: String) : Exception(message)