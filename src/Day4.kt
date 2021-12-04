import java.util.stream.Collectors

class Day4(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    private val boards = ArrayList<Board>()

    fun solvePart1(): Int {
        val numbers = input[0].split(",").stream().map { Integer.parseInt(it) }.collect(Collectors.toList())
        loadBoards()
        for (i in numbers) {
            for (b in boards) {
                val winFlag = b.runNumber(i)
                if (winFlag) {
                    return b.score
                }
            }
        }
        return -1
    }

    fun solvePart2(): Int {
        val numbers = input[0].split(",").stream().map { Integer.parseInt(it) }.collect(Collectors.toList())
        loadBoards()
        for (i in numbers) {
            for (b in boards.size - 1 downTo 0) {
                val winFlag = boards[b].runNumber(i)
                if (winFlag) {
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
        val splitString = input.split(" ").stream().filter { it != "" }.collect(Collectors.toList())
        for (i in splitString.indices) {
            array[row][i] = Integer.parseInt(splitString[i])
        }
    }

    fun runNumber(input: Int): Boolean {
        for (i in array.indices) {
            for (j in array.indices) {
                if (array[i][j] == input) {
                    array[i][j] = -1
                    val winFlag = checkForWins(i, j)
                    if (winFlag) {
                        setSum(input)
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun setSum(input: Int) {
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