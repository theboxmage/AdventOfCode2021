class Day11(filePath: String) {
    val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
        .map { it.split("").filter { i -> i != "" }.map { i -> Integer.parseInt(i) } as ArrayList }
    val points = ArrayList<Pair<Int, Int>>()

    fun solvePart1() {
        input.forEach { println(it) }
        println()
        step()
        input.forEach { println(it) }
        println()
        step()
        input.forEach { println(it) }

    }

    fun step() {
        for (y in input.indices) {
            for (x in input[y].indices) {
                input[y][x] += 1
                if(input[y][x] > 9) {
                    points.add(Pair(x, y))
                    addAround(x, y)
                }
            }
        }
        while (points.isNotEmpty()) {
            val (x, y) = points.removeAt(0)
            input[y][x] = 0
        }
    }

    private fun addAround(x: Int, y: Int) {
        for(i in -1..1) {
            for(j in -1..1) {
                if(!(i == 0 && j == 0) && input.indices.contains(x+j) && input[0].indices.contains(y+i)) {
                    input[y+i][x+j] = input[y+i][x+j] + 1
                    if(input[y+i][x+j] > 9 && !points.contains(Pair(x+j, y+i))) {
                        points.add(Pair(x+j, y+i))
                        addAround(x+j, y+i)
                    }
                }
            }
        }
    }

    fun solvePart2() {

    }
}
