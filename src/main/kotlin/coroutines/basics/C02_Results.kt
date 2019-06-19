package coroutines.basics

import kotlinx.coroutines.*

class LaunchResult {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val job = GlobalScope.launch {
                repeat(8) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
            }
            println("I am in ${Thread.currentThread()}")
            job.join()
        }
    }
}

class AsyncResult {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val times = GlobalScope.async {
                repeat(3) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
                3
            }
            println("I am in ${Thread.currentThread()}")
            println("Ran ${times.await()} times")
            println("I am still in ${Thread.currentThread()}")
        }
    }
}