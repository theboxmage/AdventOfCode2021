import java.util.stream.Collectors
import kotlin.math.abs
import kotlin.math.max

class Day5(filePath: String) {
    private val fileService = FileService(filePath)
    private var input = fileService.getLinesAsString() as ArrayList
    private val map = LinkedHashMap<String, Int>()

    fun solvePart1(): Int {
        for (s in input.size - 1 downTo 0) {
            val (x1, y1, x2, y2) = Regex("\\d+").findAll(input[s]).toList().stream().map { Integer.parseInt(it.value)}.collect(Collectors.toList())
            if (x1 == x2 || y1 == y2) {
                input.removeAt(s)
                val distance = max(abs(y1 - y2), abs(x1 - x2))
                for (i in 0..distance) {
                    val x = if (x1 != x2) x1 + i * if (x1 < x2) 1 else -1 else x1
                    val y = if (y1 != y2) y1 + i * if (y1 < y2) 1 else -1 else y1
                    addOrIncrement("$x $y")
                }
            }
        }
        return map.filter{it.value > 1}.count()
    }

    fun solvePart2(): Int {
        for (path in input) {
            val (x1, y1, x2, y2) = Regex("\\d+").findAll(path).toList().stream().map { Integer.parseInt(it.value) }.collect(Collectors.toList())
            val distance = abs(x1 - x2)
            for (i in 0..distance) {
                val x = x1 + (i * if (x1 < x2) 1 else -1)
                val y = y1 + (i * if (y1 < y2) 1 else -1)
                addOrIncrement("$x $y")
            }
        }
        return map.filter { it.value > 1 }.count()
    }

    private fun addOrIncrement(key: String) {
        if (map.containsKey(key)) {
            map[key] = map[key]!!.plus(1)
        } else {
            map[key] = 1
        }
    }
}