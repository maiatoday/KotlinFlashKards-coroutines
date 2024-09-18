import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    val job = launch {
        while(true) {
            val x = doSomething()
            println(x)
            delay(20.milliseconds)
            ensureActive()
        }
    }
    delay(10.milliseconds)
    job.cancel()
    println("\nDone")

}

suspend fun doSomething():Int {
    println("Do something")
    var counter = 0
    repeat(1000) {
        counter++
        yield() // We need something to break out the tight loop
    }
    return counter
}