import kotlinx.coroutines.*
data class FlashKard(val question: String, val answer: String)
class FlashKardQuiz(private val flashKards: List<FlashKard>) {
    private val scope = CoroutineScope(Dispatchers.Default + Job() + CoroutineName("FlashKardQuiz"))

    fun startQuiz() = scope.launch {
        for (card in flashKards) {
            println("Question: ${card.question}")
            delay(2000)  // Simulate thinking time
            println("Answer: ${card.answer}")
        }
    }

    fun stopQuiz() {
        // Since we have the scope we can cancel it
        scope.cancel()
    }
}

fun main() = runBlocking {
    val flashKards = listOf(
        FlashKard("What language primitive is used to indicate that a function can pause execution without blocking?", "suspend"),
        FlashKard("How would you start a new coroutine when you don’t care about the return value??", "launch"),
        FlashKard("Which coroutine builder is suitable if you want to return a result? How do you get the result?", "async / await"),
    )

    val quiz = FlashKardQuiz(flashKards)

    quiz.startQuiz()

    // Run the quiz for a specified duration
    delay(7000)

    // Then stop the quiz
    quiz.stopQuiz()
}