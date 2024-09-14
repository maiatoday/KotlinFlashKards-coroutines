import kotlinx.coroutines.*

fun main(): Unit = test()

fun test() {
    runBlocking {

        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            println("Custom Error handler: $exception")
        }

        launch(exceptionHandler) {
            crashyFunction("Oops! where is this caught")
        }

    }
}

fun crashyFunction(message: String) {
    throw UnsupportedOperationException(message)
}
