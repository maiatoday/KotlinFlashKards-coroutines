import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main(): Unit = runBlocking {

    val answer = async {
        crashyFunction("Oops!")
    }

    println("No exception yet")
    delay(100.milliseconds)
    answer.await()
}

fun crashyFunction(message: String) {
    throw UnsupportedOperationException(message)
}


