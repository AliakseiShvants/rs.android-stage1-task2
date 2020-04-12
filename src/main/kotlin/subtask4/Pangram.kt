package subtask4

private const val EMPTY = ""

private val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')
private val upperLetter = 'A'.toInt()..'Z'.toInt()
private val lowerLetter = 'a'.toInt()..'z'.toInt()

class Pangram {

    fun getResult(inputString: String): String = when {
        isPangram(inputString) -> convert(inputString)
        else -> convert(inputString, false)
    }

    private fun convert(inputString: String, isPangram: Boolean = true): String {
        val inputLine = inputString.trim()
        var result = EMPTY

        if (inputLine.isEmpty()) {
            return result
        }

        val words = inputLine.split("[ \n]+".toRegex()).map { StringBuilder(it) }

        words.forEach { word ->
            var letterCount = 0

            word.asIterable().forEachIndexed { index, letter ->
                val condition = when {
                    isPangram -> vowels.contains(letter) && isLetter(letter)
                    else -> !vowels.contains(letter) && isLetter(letter)
                }

                if (condition) {
                    word[index] = letter.toUpperCase()
                    letterCount++
                }
            }

            word.insert(0, letterCount)
        }

        words.sortedBy { it.first() }.forEach { result += "$it " }

        return result.trim()
    }

    private fun isPangram(inputString: String) = inputString.toCharArray()
        .filter { isLetter(it) }
        .map { it.toUpperCase() }
        .toSet()
        .count() == 26

    private fun isLetter(letter: Char) = with(letter.toInt()) {
        this in upperLetter || this in lowerLetter
    }
}
