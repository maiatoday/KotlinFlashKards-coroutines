import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    // Launching a coroutine and getting a reference
    val handleToCoroutine: Job = launch {
        repeat(1000) { i ->
            println("I'm working on task $i ...")
            delay(500.milliseconds)
        }
    }

    // Delay the main coroutine to let the launched coroutine do some work
    delay(1300.milliseconds)
    println("main: I'm tired of waiting!")

    // Cancelling the job
    handleToCoroutine.cancelAndJoin()
    println("main: Now I can quit.")
}