import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    val job = launch {
        while(isActive) {
            val x = doSomething()
            println(x)
        }
    }
    delay(200.milliseconds)
    job.cancel()
    println("\nDone")

}

suspend fun doSomething():Int {
    println("Do something")
    var counter = 0
    repeat(5) {
        counter++
        delay(10.milliseconds) // suspend function so it can be cancelled
    }
    return counter
}