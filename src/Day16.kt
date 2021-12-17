class Day16(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    var versionSum = 0
    var output = Pair(0L, 0)
    private val badIdea = mapOf(
        "0" to "0000",
        "1" to "0001",
        "2" to "0010",
        "3" to "0011",
        "4" to "0100",
        "5" to "0101",
        "6" to "0110",
        "7" to "0111",
        "8" to "1000",
        "9" to "1001",
        "A" to "1010",
        "B" to "1011",
        "C" to "1100",
        "D" to "1101",
        "E" to "1110",
        "F" to "1111"
    )

    fun solvePart1(): Int {
        val binary = createString()
        output = step(binary)
        return versionSum
//        println(runId4("101111111000101000"))
    }

    fun solvePart2(): Long {
        return output.first
    }

    private fun step(input: String): Pair<Long, Int> {
        var i = 0
        val version = Integer.parseInt(input.substring(i, i + 3), 2)
        val id = Integer.parseInt(input.substring(i + 3, i + 6), 2)
        val valueList = ArrayList<Long>()
        versionSum += version
        i += 6
        var j = 0
        if (id == 4) {
            val (value, index) = runId4(input.substring(i))
            i += index
            return Pair(value, i)
        } else {
            if (input.substring(i, i + 1) == "0") {
                val lengthString = Integer.parseInt(input.substring(i + 1, i + 16), 2)
                val subPacket = input.substring(i + 16, i + lengthString + 16)
                while (j < subPacket.length) {
                    val pair = step(subPacket.substring(j))
                    valueList.add(pair.first)
                    j += pair.second
                }
                return Pair(runOperation(id, valueList), i + j + 16)
            } else {
                val lengthString = Integer.parseInt(input.substring(i + 1, i + 12), 2)
                val subPacket = input.substring(i + 12)
                for (x in 0 until lengthString) {
                    val temp = subPacket.substring(j)
                    val pair = step(temp)
                    valueList.add(pair.first)
                    j += pair.second
                }
                return Pair(runOperation(id, valueList), i + j + 12)
            }
        }
    }

    private fun runOperation(id: Int, valueList: java.util.ArrayList<Long>): Long {
        when (id) {
            0 -> {
                return valueList.sum()
            }
            1 -> {
                var temp = -1L
                for (i in valueList) {
                    if (temp == -1L) {
                        temp = i
                    } else {
                        temp *= i
                    }
                }
                return temp
            }
            2 -> {
                return valueList.minOf { it }
            }
            3 -> {
                return valueList.maxOf { it }
            }
            5 -> {
                return if (valueList[0] > valueList[1]) 1 else 0
            }
            6 -> {
                return if (valueList[0] < valueList[1]) 1 else 0
            }
            7 -> {
                return if (valueList[0] == valueList[1]) 1 else 0
            }
        }
        return -1
    }


    private fun createString(): String {
        var output = ""
        for (i in input[0]) {
            output += badIdea[i.toString()]
        }
        return output
    }

    fun runId4(input: String): Pair<Long, Int> {
        var i = 0
        var string = ""
        while (i < input.length) {
            string += input.substring(i + 1, i + 5)
            if (input[i] == '1') {
                i += 5
            } else {
                i += 5
                break
            }
        }
        return Pair(string.toLong(2), i)
    }


}
