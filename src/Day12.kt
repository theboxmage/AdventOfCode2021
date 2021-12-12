class Day12(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    private val map = LinkedHashMap<String, MapElement>()

    class MapElement {
        var paths = ArrayList<String>()

        fun addNode(element: String) {
            if (!paths.contains(element) && element != "start") {
                paths.add(element)
            }
        }
    }

    fun solvePart1(): Int {
        for (i in input) {
            val (start, end) = i.split("-")
            if (!map.contains(start)) {
                map[start] = MapElement()
            }
            if (!map.contains(end)) {
                map[end] = MapElement()
            }
            map[start]!!.addNode(end)
            map[end]!!.addNode(start)
        }
        return step("start")
    }

    private fun step(key: String, caveCap: Int = 0, path: ArrayList<String> = ArrayList(mutableListOf("start"))): Int {
        if (key == "end") {
            return 1
        } else {
            var count = 0
            for (i in map[key]!!.paths) {
                if (!(path.contains(i) && (i.all { it.isLowerCase() } && countLowercasePairs(path) >= caveCap))) {
                    val newPath = ArrayList(path)
                    newPath.add(i)
                    count += step(i, caveCap, newPath)
                }
            }
            return count
        }
    }

    private fun countLowercasePairs(path: ArrayList<String>): Int {
        var count = 0
        for (i in path.filter{it.all{i -> i.isLowerCase()}}) {
            if(path.filter{it == i}.size > 1) {
                count++
            }
        }
        return count/2
    }

    fun solvePart2(): Int {
        return step("start", 1)
    }
}