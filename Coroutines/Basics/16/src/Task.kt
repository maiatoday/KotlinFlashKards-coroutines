import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking {
    val compilerIntrinsicInfo = coroutineContext
    println("isActive: ${compilerIntrinsicInfo.isActive}")
    check(compilerIntrinsicInfo.isActive)
    check(compilerIntrinsicInfo[Job] is Job)
    println("contains a Job ${compilerIntrinsicInfo[Job] is Job}")
    check(compilerIntrinsicInfo[CoroutineDispatcher] is CoroutineDispatcher)
    println("contains a Job ${compilerIntrinsicInfo[CoroutineDispatcher] is CoroutineDispatcher}")
}