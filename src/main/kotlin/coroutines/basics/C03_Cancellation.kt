package coroutines.basics

import kotlinx.coroutines.*

class NoCancel {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val job = GlobalScope.launch {
                repeat(100) {
                    println("Executing $it in ${Thread.currentThread()}")
                    Thread.sleep(1000L)
                }
            }
            delay(5000L)
            job.cancel()
            println("I'm in ${Thread.currentThread()}")
            delay(5000L)
            println("I'm still in ${Thread.currentThread()}")
        }
    }
}

class CooperativeCancel {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val job = GlobalScope.launch {
                repeat(100) {
                    if (isActive) {
                        println("Executing $it in ${Thread.currentThread()}")
                        Thread.sleep(1000L)
                    }
                }
            }
            delay(5000L)
            job.cancel()
            println("I'm in ${Thread.currentThread()}")
            delay(5000L)
            println("I'm still in ${Thread.currentThread()}")
        }
    }
}

class CancelAndJoin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val job = GlobalScope.launch {
                repeat(100) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
            }
            job.cancelAndJoin()
        }
    }
}