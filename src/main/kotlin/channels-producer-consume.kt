import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

fun main(args: Array<String>) {
    runBlocking {
        val scope = CoroutineScope(Dispatchers.Unconfined)
        val channel = scope.produce<Int> {
            for (i in 0..30 step 2) send(i xor 31)
            delay(100)
        }

        scope.launch {
            channel.consumeEach {
                println(it)
            }
        }
    }
}