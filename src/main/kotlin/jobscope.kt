import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val jobScope = Job()
        val coroutineScope = CoroutineScope(Dispatchers.Default + jobScope)
        val coroutineJob = coroutineScope.launch {
            println("Custom context")
        }

        coroutineJob.join()
    }
}