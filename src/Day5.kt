import java.util.stream.Collectors

class Day5(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString() as ArrayList
    private val map = LinkedHashMap<String, Int>()

    fun solvePart1(): Long {
        for (s in input.size - 1 downTo 0) {
            val p = Path(input[s])
            if (p.x1 == p.x2) {
                input.remove(input[s])
                if (p.y1 < p.y2) {
                    for (i in p.y1..p.y2) {
                        addOrIncrement("${p.x1} $i")
                    }
                } else {
                    for (i in p.y1 downTo p.y2) {
                        addOrIncrement("${p.x1} $i")
                    }
                }
            } else if (p.y1 == p.y2) {
                input.remove(input[s])
                if (p.x1 < p.x2) {
                    for (i in p.x1..p.x2) {
                        addOrIncrement("$i ${p.y1}")
                    }
                } else {
                    for (i in p.x1 downTo p.x2) {
                        addOrIncrement("$i ${p.y1}")
                    }
                }
            }
        }
        return map.toList().stream().filter { it.second > 1 }.count()
    }

    fun solvePart2() {
        for (path in input) {
            val p = Path(path)
            val distance = Math.abs(p.x1 - p.x2)
            for (i in 0..distance) {
                val x = p.x1 + (i * if (p.x1 < p.x2) 1 else -1)
                val y = p.y1 + (i * if (p.y1 < p.y2) 1 else -1)
                addOrIncrement("$x $y")
            }
        }
        println(map.toList().stream().filter { it.second > 1 }.count())
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