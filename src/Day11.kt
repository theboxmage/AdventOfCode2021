class Day11(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
        .map { it.split("").filter { i -> i != "" }.map { i -> Integer.parseInt(i) } as ArrayList }
    private val points = ArrayList<Pair<Int, Int>>()
    private var count = 0
    fun solvePart1(): Int {
        for (i in 0 until 100) {
            step()
        }
        return count
    }

    fun solvePart2(): Int {
        var sum = 100
        while (input.any { it.any { i -> i != 0 } }) {
            step()
            sum++
        }
        return sum
    }

    private fun step() {
        for (y in input.indices) {
            for (x in input[0].indices) {
                input[y][x]++
                if (input[y][x] > 9) {
                    points.add(points.size, Pair(x, y))
                }
            }
        }
        while (points.isNotEmpty()) {
            val (first, second) = points.removeAt(0)
            addAround(first, second)
        }
        for (i in input.indices) {
            for (j in input.indices) {
                if (input[i][j] > 9) {
                    input[i][j] = 0
                }
            }
        }
    }

    private fun addAround(x: Int, y: Int) {
        count++
        for (i in -1..1) {
            for (j in -1..1) {
                if (!(i == 0 && j == 0) && input.indices.contains(y + j) && input[0].indices.contains(x + i)) {
                    input[y + j][x + i]++
                    if (input[y + j][x + i] == 10) {
                        points.add(points.size, Pair(x + i, y + j))
                    }
                }
            }
        }
    }
}
