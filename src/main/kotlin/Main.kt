import kotlin.js.Date

fun main() {
    val generator = RecursiveFibonacciGenerator(30)
    //val generator = ClosedRangeGenerator(0, 100000000, 1)
    generator.resetGenerator()

    var s = 0
    var i = 0

    val t1 = Date().getTime()
    CoroutineStub.evaluate {
        while (generator.hasNext()) {
            s += generator.nextValue()
            ++i
        }
    }
    val t2 = Date().getTime()

    println("sum: $s, iterations: $i")
    println("time: ${t2 - t1} ms")
}
