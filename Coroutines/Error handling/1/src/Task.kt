import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    try {
        val job = launch {
            try { //<=== comment out the try catch to see what happens
            repeat(4) {
                println("Tick")
                if (it == 2) {
                    throw TheBombException("Boom!")
                }
            }
            } catch (e: TheBombException) {
                println("Caught exception in coroutine: ${e.message}")
            }
        }

        job.join()
    } catch (e: TheBombException) {
        println("Caught exception in runBlocking: ${e.message}")
    }
}

class TheBombException(message: String) : Exception(message)