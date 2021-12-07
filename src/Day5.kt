import java.util.stream.Collectors
import kotlin.math.abs
import kotlin.math.max

class Day5(filePath: String) {
    private val fileService = FileService(filePath)
    private var input = fileService.getLinesAsString() as ArrayList
    private val map = LinkedHashMap<String, Int>()

    fun solvePart1(): Int {
        for (s in input.size - 1 downTo 0) {
            val p = Path(input[s])
            if (p.x1 == p.x2 || p.y1 == p.y2) {
                input.removeAt(s)
                val distance = max(abs(p.y1 - p.y2), abs(p.x1 - p.x2))
                for (i in 0..distance) {
                    val x = if (p.x1 != p.x2) p.x1 + i * if (p.x1 < p.x2) 1 else -1 else p.x1
                    val y = if (p.y1 != p.y2) p.y1 + i * if (p.y1 < p.y2) 1 else -1 else p.y1
                    addOrIncrement("$x $y")
                }
            }
        }
        return map.filter{it.value > 1}.count()
    }

    fun solvePart2(): Int {
        for (path in input) {
            val p = Path(path)
            val distance = abs(p.x1 - p.x2)
            for (i in 0..distance) {
                val x = p.x1 + (i * if (p.x1 < p.x2) 1 else -1)
                val y = p.y1 + (i * if (p.y1 < p.y2) 1 else -1)
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

class Path(input: String) {
    val x1: Int
    val y1: Int
    val x2: Int
    val y2: Int

    init {
        val toList = Regex("\\d+").findAll(input).toList().stream().map { it.value }.collect(Collectors.toList())
        x1 = Integer.parseInt(toList[0])
        y1 = Integer.parseInt(toList[1])
        x2 = Integer.parseInt(toList[2])
        y2 = Integer.parseInt(toList[3])
    }
}