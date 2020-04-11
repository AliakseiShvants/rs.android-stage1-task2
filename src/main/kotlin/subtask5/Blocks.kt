package subtask5

import java.time.LocalDate
import java.time.LocalDate.now
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

private const val EMPTY = ""
private const val PATTERN2 = "dd.mm.yyyy"

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any = when (blockB) {
        Int::class -> (blockA.filter { it::class == Int::class } as List<Int>).sum()

        String::class -> {
            (blockA.filter { it::class == String::class } as List<String>)
                .toTypedArray()
                .joinToString(separator = EMPTY) { it }
        }

        else -> {
            val dateList = (blockA.filter { it::class == LocalDate::class } as List<LocalDate>)
            val diffList = dateList.map { now().toEpochDay() - it.toEpochDay() }
            val minDiff = diffList.min() ?: 0L

            diffList.forEachIndexed { index, value ->
                if (value == minDiff) {
                    return dateList[index].format(DateTimeFormatter.ofPattern(PATTERN2))
                }
            }
        }
    }
}
