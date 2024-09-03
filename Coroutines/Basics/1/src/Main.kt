import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
// A sample to show how you can run many coroutines because they are light-weight.
// Feel free to run the code by pressing the green run icon in the gutter.
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(100.milliseconds)
            print(".")
        }
    }
    println("Waiting for the dots to appear!")
}
