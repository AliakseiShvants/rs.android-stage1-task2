package subtask1

import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

private const val ERROR_DAY = "Такого дня не существует"
private const val RU = "RU"

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String) = runCatching {
        val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        val monthToString = date.month.getDisplayName(TextStyle.FULL, Locale(RU))
        val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale(RU))

        "$day $monthToString, $dayOfWeek"
    }.getOrElse {
        ERROR_DAY
    }
}
