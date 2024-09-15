import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    try {
        val job = launch {
            try { //<=== comment out the try catch to see what happens
            repeat(4) {
                println("Tick")
                if (it == 2) {
                    throw StopTheClockException("Boom!")
                }
            }
            } catch (e: StopTheClockException) {
                println("Caught exception in coroutine: ${e.message}")
            }
        }

        job.join()
    } catch (e: StopTheClockException) {
        println("Caught exception in runBlocking: ${e.message}")
    }
}

class StopTheClockException(message: String) : Exception(message)