package coroutines.basics

abstract interface ISample {
    fun what()
    fun why()
}


sealed class Game {
    abstract fun what()

    object Yoko : Game() {
        override fun what() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    object Moko : Game() {
        override fun what() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}


