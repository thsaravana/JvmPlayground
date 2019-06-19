package coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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