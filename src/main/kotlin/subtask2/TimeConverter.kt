package subtask2

private const val O_CLOCK = "o' clock"
private const val EMPTY = ""
private const val HOUR_ERROR = "No such hour exists"
private const val MINUTE_ERROR = "No such minute exists"

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String = runCatching {
        val hourToDigit = hour.toInt()
        val minuteToDigit = minute.toInt()

        val hourToString =
            if (minuteToDigit > 30) getHourString(hourToDigit + 1) else getHourString(hourToDigit)
        val minuteToString = getMinuteString(minuteToDigit)

        if (minuteToString == O_CLOCK) "$hourToString $minuteToString" else "$minuteToString $hourToString"
    }.getOrElse {
        EMPTY
    }

    private fun getHourString(hour: Int): String = try {
        if (hour in 1..23) getNumberString(hour) else throw IllegalArgumentException(HOUR_ERROR)
    } catch (e: Exception) {
        throw IllegalArgumentException(HOUR_ERROR)
    }

    private fun getMinuteString(minute: Int): String = try {
        when (minute) {
            0 -> O_CLOCK
            in 1..29 -> if (minute == 15) {
                "quarter past"
            } else {
                val line = "${getNumberString(minute)} minute"

                "${if (minute == 1) line else line + "s"} past"
            }
            30 -> "half past"
            in 31..59 -> if (minute == 45) {
                "quarter to"
            } else {
                val line = "${getNumberString(60 - minute)} minute"

                "${if (60 - minute == 1) line else line + "s"} to"
            }
            else -> throw IllegalArgumentException(MINUTE_ERROR)
        }
    } catch (e: Exception) {
        throw IllegalArgumentException(MINUTE_ERROR)
    }

    private fun getNumberString(number: Int): String = when (number) {
        0 -> "zero"
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        10 -> "ten"
        11 -> "eleven"
        12 -> "twelve"
        13 -> "thirteen"
        14 -> "fourteen"
        15 -> "fifteen"
        16 -> "sixteen"
        17 -> "seventeen"
        18 -> "eighteen"
        19 -> "nineteen"
        20 -> "twenty"
        21 -> "twenty one"
        22 -> "twenty two"
        23 -> "twenty three"
        24 -> "twenty four"
        25 -> "twenty five"
        26 -> "twenty six"
        27 -> "twenty seven"
        28 -> "twenty eight"
        29 -> "twenty nine"
        30 -> "thirty"
        else -> throw IllegalStateException()
    }
}
