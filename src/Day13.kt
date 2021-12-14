import kotlin.math.abs

class Day13(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    private val points = input.filter { it != "" && it[0].isDigit() }.map { it.split(",").map { i -> Integer.parseInt(i) } }
        .map { Pair(it[0], it[1]) } as ArrayList
    private val paper = LinkedHashMap<Pair<Int, Int>, String>()
    private val folds = input.filter { it != "" && it[0] == 'f' }.map { it.split(" ")[2] } as ArrayList

    fun solvePart1() {
        for (i in points) {
            paper[i] = "#"
        }
        fold(folds.removeAt(0))
        println(paper.size)
    }

    fun solvePart2() {
        while(folds.isNotEmpty()) {
            fold(folds.removeAt(0))
        }
        printPaper()
    }

    private fun printPaper(spacer: String = " ") {
        val maxX = paper.maxOf { it.key.first }
        val maxY = paper.maxOf { it.key.second }
        for (y in 0..maxY) {
            for (x in 0..maxX) {
                if (paper.containsKey(Pair(x, y))) {
                    print("#")
                } else {
                    print(spacer)
                }
            }
            println()
        }
    }

    private fun fold(foldOn: String) {
        println(foldOn)
        var (axis, index) = foldOn.split("=")
        if (axis == "y") {
            val temp = paper.filter { it.key.second > Integer.parseInt(index) }
            for (i in temp) {
                paper[Pair(i.key.first, abs(i.key.second - index.toInt() * 2))] = "#"
                paper.remove(i.key)
            }
        } else {
            val temp = paper.filter { it.key.first > Integer.parseInt(index) }
            for (i in temp) {
                paper[Pair(abs(i.key.first - index.toInt() * 2), i.key.second)] = "#"
                paper.remove(i.key)
            }
        }
    }
}
