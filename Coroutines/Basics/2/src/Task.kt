import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

suspend fun hello(): String {
    delay(1.seconds)
    return "Hello World!"
}