import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.random.Random

val channel:Channel<Int> = Channel {  }
fun main(args: Array<String>) {
    runBlocking {
        val scope = CoroutineScope(Dispatchers.Unconfined)

        val job1 = scope.launch {
            iterate()
        }

        val job2 = scope.launch {
            receiveChan()
        }

        job1.join()
        job2.join()
    }
}

suspend fun iterate() {
    for (i in 0..20 step 2) {
        channel.send(i)
        delay(Random.nextLong(5_000))
    }
    channel.close()
}

suspend fun receiveChan() {
   for (i in channel) {
       println(i)
   }
}