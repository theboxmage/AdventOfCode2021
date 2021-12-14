class Day14(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    private val key = input.filter { it.contains("->") }.associateBy({ it.split(" ")[0] }, { it.split(" ")[2] })
    fun solvePart1(): Long {
        var path = load()
        for (i in 0 until 10) {
            path = step(path)
        }

        return calculateAnswer(path)
    }

    fun solvePart2(): Long {
        var path = load()
        for (i in 0 until 40) {
            path = step(path)
        }

        return calculateAnswer(path)
    }

    private fun calculateAnswer(path: LinkedHashMap<String, Long>): Long {
        val characterList = path.map { it.key[0] }
        val sumList: MutableMap<String, Long> = mutableMapOf()
        for (i in characterList) {
            sumList[i.toString()] = path.filter { it.key[0] == i }.toList().sumOf { it.second }
        }
        sumList[input[0][input[0].length-1].toString()] = sumList[input[0][input[0].length-1].toString()]!! + 1
        return sumList.maxOf{it.value} - sumList.minOf{it.value}
    }

    private fun step(path: LinkedHashMap<String, Long>): LinkedHashMap<String, Long> {
        val newPath = LinkedHashMap<String, Long>()
        for (i in path) {
            if (path.containsKey(i.key)) {
                val leftKey = "${i.key[0]}${key[i.key]}"
                val rightKey = "${key[i.key]}${i.key[1]}"
                newPath[leftKey] = i.value + getValue(newPath, leftKey)
                newPath[rightKey] = i.value + getValue(newPath, rightKey)

            } else {
                newPath[i.key] = i.value
            }
        }
        return newPath
    }

    private fun getValue(path: java.util.LinkedHashMap<String, Long>, key: String): Long {
        return if (path.containsKey(key)) path[key]!! else 0
    }


    private fun load(): LinkedHashMap<String, Long> {
        val path = LinkedHashMap<String, Long>()
        for (i in 0 until input[0].length - 1) {
            val pair = input[0].substring(i, i + 2)
            if (path.containsKey(pair)) {
                path[pair] = path[pair]!! + 1
            } else {
                path[pair] = 1
            }
        }
        return path
    }
}