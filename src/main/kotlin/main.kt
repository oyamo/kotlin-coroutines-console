import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        launch {
            delay(100)
            println("The first coroutine")
        }

        launch {
            delay(20)
            println("The last coroutine")
        }

        println("No coroutine")
    }
}