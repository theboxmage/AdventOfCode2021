class Day4(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    private val boards = ArrayList<Board>()
    private val numbers = input[0].split(",").map { Integer.parseInt(it) }

    fun solvePart1(): Int {
        loadBoards()
        for (i in numbers) {
            for (b in boards) {
                if (b.runNumber(i)) {
                    return b.getSum(i)
                }
            }
        }
        return -1
    }

    fun solvePart2(): Int {
        for (i in numbers) {
            for (b in boards.size - 1 downTo 0) {
                if (boards[b].runNumber(i)) {
                    if (boards.size == 1) {
                        return boards[b].getSum(i)
                    }
                    boards.remove(boards[b])
                }
            }
        }
        return -1
    }

    private fun loadBoards() {
        for (i in 2 until input.size step 6) {
            val b = Board()
            for (j in 0..4) {
                b.setRow(input[i + j], j)
            }
            boards.add(boards.size, b)
        }
    }
}

class Board {
    private val array = Array(5) { IntArray(5) }
    fun setRow(input: String, row: Int) {
        val splitString = Regex("\\d+").findAll(input).toList()
        for (i in 0..4) {
            array[row][i] = Integer.parseInt(splitString[i].value)
        }
    }

    fun runNumber(input: Int): Boolean {
        for (i in 0..4) {
            for (j in 0..4) {
                if (array[i][j] == input) {
                    array[i][j] = -1
                    if (checkForWins(i, j)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun getSum(input: Int): Int {
        return array.sumOf { it.filter { it != -1 }.sum() } * input
    }

    private fun checkForWins(x: Int, y: Int): Boolean {
        var winOnX = true
        var winOnY = true
        for (i in 0..4) {
            if (array[x][i] != -1) {
                winOnY = false
            }
            if (array[i][y] != -1) {
                winOnX = false
            }
        }
        return winOnX || winOnY
    }
}