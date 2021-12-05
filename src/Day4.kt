import java.util.stream.Collectors

class Day4(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    private val boards = ArrayList<Board>()
    private val numbers = input[0].split(",").stream().map { Integer.parseInt(it) }.collect(Collectors.toList())

    fun solvePart1(): Int {
        loadBoards()
        for (i in numbers) {
            for (b in boards) {
                if (b.runNumber(i)) {
                    return b.score
                }
            }
        }
        return -1
    }

    fun solvePart2(): Int {
        loadBoards()
        for (i in numbers) {
            for (b in boards.size - 1 downTo 0) {
                if (boards[b].runNumber(i)) {
                    if(boards.size == 1)
                    {
                        return boards[b].score
                    }
                    boards.remove(boards[b])
                }
            }
        }
        return -1
    }

    private fun loadBoards() {
        var counter = 0
        var b = Board()
        for (i in 2 until input.size) {
            if (input[i] == "") {
                counter = 0
                boards.add(boards.size, b)
                b = Board()
            } else {
                b.setRow(input[i], counter)
                counter++
            }
        }
        boards.add(boards.size, b)
    }
}

class Board {
    private val array = Array(5) { IntArray(5) }
    var score = 0
    fun setRow(input: String, row: Int) {
        val splitString = Regex("\\d+").findAll(input).toList()
        for (i in 0..4) {
            array[row][i] = Integer.parseInt(splitString[i].value)
        }
    }

    fun runNumber(input: Int): Boolean {
        for (i in array.indices) {
            for (j in array.indices) {
                if (array[i][j] == input) {
                    array[i][j] = -1
                    if (checkForWins(i, j)) {
                        getSum(input)
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun getSum(input: Int) {
        var sum = 0
        for (row in array) {
            for (number in row) {
                sum += if (number != -1) number else 0
            }
        }
        score = sum * input
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