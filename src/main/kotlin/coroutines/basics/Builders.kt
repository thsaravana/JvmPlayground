package coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    launch()
}

private fun launch() {
    GlobalScope.launch {
        repeat(100) {
            println("Executing $it in ${Thread.currentThread()}")
            delay(1000L)
        }
    }
    println("I am in ${Thread.currentThread()}")
    Thread.sleep(5000L)
}