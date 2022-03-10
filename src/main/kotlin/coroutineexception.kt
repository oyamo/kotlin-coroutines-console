import kotlinx.coroutines.*
import java.security.InvalidParameterException

fun main() {
    runBlocking {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("E rror: ${throwable.localizedMessage}")
        }

        val scope = CoroutineScope(Dispatchers.Unconfined)
        scope.launch(exceptionHandler) {
            brittleAsync(false)
            brittleAsync(true)
        }
    }
}

suspend fun brittleAsync(ex: Boolean) {
    if (ex) {
        throw InvalidParameterException("Invalid parameter")
    }
}