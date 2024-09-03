import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    doSomethingBlocking()
}

fun doSomethingBlocking() = runBlocking {
    delay(100.milliseconds)
    println ("I have control of the thread!")
}