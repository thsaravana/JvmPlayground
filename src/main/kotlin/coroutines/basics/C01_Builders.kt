package coroutines.basics

import kotlinx.coroutines.*

class Launch {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GlobalScope.launch {
                repeat(100) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
            }
            println("I am in ${Thread.currentThread()}")
            Thread.sleep(5000L)
        }
    }
}

class AsyncWithoutAwait {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GlobalScope.async {
                repeat(100) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
            }
            println("I am in ${Thread.currentThread()}")
            Thread.sleep(5000L)
        }
    }
}

class RunBlocking1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runBlocking {
                repeat(5) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
            }
            println("I am in ${Thread.currentThread()}")
            Thread.sleep(5000L)
        }
    }
}

class RunBlocking2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            repeat(5) {
                println("Executing $it in ${Thread.currentThread()}")
                delay(1000L)
            }
            println("I am in ${Thread.currentThread()}")
        }
    }
}

class RunBlocking3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            GlobalScope.launch {
                repeat(100) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
            }
            println("I am in ${Thread.currentThread()}")
            delay(5000L)
        }
    }
}

class AsyncWithAwait {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val async = GlobalScope.async {
                repeat(8) {
                    println("Executing $it in ${Thread.currentThread()}")
                    delay(1000L)
                }
            }
            println("I am in ${Thread.currentThread()}")
            async.await()
        }
    }
}