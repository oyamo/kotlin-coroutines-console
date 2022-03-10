import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() {


    runBlocking {
       val deffered = async {
           defferedRun()
       }

        deffered.await()
    }
}

suspend fun defferedRun() {
    println("Hello from deffered job")
}