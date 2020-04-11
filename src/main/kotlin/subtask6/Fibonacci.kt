package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var first: Int
        var second: Int
        var bit = 0
        var x = 0
        var prod: Int

        do {
            first = getFIByOrder(x)
            second = getFIByOrder(x + 1)
            prod = first * second

            if (prod == n) {
                bit = 1

                break
            }

            x++
        } while (prod < n)

        return intArrayOf(first, second, bit)
    }

    private fun getFIByOrder(position: Int): Int = when (position) {
        0 -> 0
        1 -> 1
        else -> getFIByOrder(position - 2) + getFIByOrder(position - 1)
    }
}
