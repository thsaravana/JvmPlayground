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

class CancelFinally {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val job = GlobalScope.launch {
                try {
                    repeat(100) {
                        println("Executing $it in ${Thread.currentThread()}")
                        delay(1000L)
                    }
                } finally {
                    println("Invoking Finally on Cancellation in ${Thread.currentThread()}")
                }
            }
            // No time to call finally
            job.cancel()
        }
    }
}

class CancelAndJoinFinally {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val job = GlobalScope.launch {
                try {
                    repeat(100) {
                        println("Executing $it in ${Thread.currentThread()}")
                        delay(1000L)
                    }
                } finally {
                    println("Invoking Finally on Cancellation in ${Thread.currentThread()}")
                }
            }
            // Cancel and waits for the job to finish. Hence Finally will be called.
            job.cancelAndJoin()
        }
    }
}