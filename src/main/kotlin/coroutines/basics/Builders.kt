package coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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