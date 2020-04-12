package subtask3

private const val NO = "NO"
private const val YES = "YES"
class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val input = StringBuilder(a.toUpperCase())
        val expected = b.toCharArray()

        var index = 0
        var result = NO

        while (index < b.length) {
            if (expected[index] != input[index]) {
                result = NO
                input.deleteCharAt(index)
            } else {
                result = YES
                index++
            }

            if (index > input.lastIndex) {
                if (input.length != b.length) {
                    result = NO

                    break
                }

                break
            }
        }

        return result
    }
}