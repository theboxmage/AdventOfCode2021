class Day9(filePath: String) {
    val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString().map { it.split("") }
        .map { it.filter { i -> i != "" }.map { i -> Integer.parseInt(i) } }
    private val lowPoints = ArrayList<Pair<Int, Int>>()

    fun solvePart1(): Int {
        var count = 0
        for (y in input.indices) {
            for (x in input[y].indices) {
                if (checkLow(x, y)) {
                    lowPoints.add(Pair(x, y))
                    count += getPoint(x, y) + 1
                }
            }
        }
        return count
    }

    fun solvePart2(): Int {
        val sizeList = ArrayList<Int>()
        for (low in lowPoints) {
            sizeList.add(getBasinSize(low))
        }
        sizeList.sortDescending()
        return sizeList[0]*sizeList[1]*sizeList[2]
    }

    private fun getBasinSize(point: Pair<Int, Int>): Int {
        val remainingPoints = ArrayList<Pair<Int, Int>>(arrayListOf(point))
        val consumedPoints = ArrayList<Pair<Int, Int>>()
        while (remainingPoints.isNotEmpty()) {
            val (x, y) = remainingPoints[0]
            val value = getPoint(x, y)
            consumedPoints.add(remainingPoints.removeAt(0))
            for (i in -1..1 step 2) {
                if (checkPoint(x + i, y, value) && !checkLists(consumedPoints, remainingPoints, Pair(x + i, y))) {
                    remainingPoints.add(Pair(x + i, y))
                }
                if (checkPoint(x, y + i, value) && !checkLists(consumedPoints, remainingPoints, Pair(x, y + i))) {
                    remainingPoints.add(Pair(x, y + i))
                }
            }
        }
        return consumedPoints.size
    }

    private fun checkLists(l1: ArrayList<Pair<Int, Int>>, l2: ArrayList<Pair<Int, Int>>, pair: Pair<Int, Int>): Boolean {
        return l1.contains(pair) || l2.contains(pair)
    }

    private fun checkPoint(x: Int, y: Int, value: Int): Boolean {
        return getPoint(x, y) in (value + 1)..8
    }

    private fun getPoint(x: Int, y: Int): Int {
        if (input.indices.contains(y) && input[0].indices.contains(x)) {
            return input[y][x]
        }
        return 9
    }

    private fun checkLow(x: Int, y: Int): Boolean {
        val value = getPoint(x, y)
        return getPoint(x - 1, y) > value && getPoint(x + 1, y) > value && getPoint(x, y - 1) > value && getPoint(x, y + 1) > value
    }
}