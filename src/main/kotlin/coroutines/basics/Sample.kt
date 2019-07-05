package coroutines.basics

class Sample: ISample {
    override fun what() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun why() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    internal var i = 0
    internal var j = 1

    internal fun get(): Int {
        return i
    }

    internal fun add(i: Int, j: String): Int {
        return 3
    }
}

