class Day16(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()
    var versionSum = 0
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
        step(binary)
        return versionSum
//        println(runId4("101111111000101000"))
    }

    private fun step(input: String): Pair<Int, Int> {
        var i = 0
        val version = Integer.parseInt(input.substring(i, i + 3), 2)
        val id = Integer.parseInt(input.substring(i + 3, i + 6), 2)
        versionSum += version
        i += 6
        var j = 0
        if (id == 4) {
            val (value, index) = runId4(input.substring(i))
            i += index
            println("Value Found: $value")
            return Pair(value, i)
        } else {
            if (input.substring(i, i + 1) == "0") {
                val lengthString = Integer.parseInt(input.substring(i + 1, i + 16), 2)
                val subPacket = input.substring(i + 16, i + lengthString + 16)
                while (j < subPacket.length) {
                    val pair = step(subPacket.substring(j))
                    j += pair.second
                }
            } else {
                val lengthString = Integer.parseInt(input.substring(i + 1, i + 12), 2)
                val subPacket = input.substring(i + 12)
                for (x in 0 until lengthString) {
                    val pair = step(subPacket.substring(j))
                    j += pair.second
                }
            }
        }
        return Pair(0, i)
    }


    private fun createString(): String {
        var output = ""
        for (i in input[0]) {
            output += badIdea[i.toString()]
        }
        return output
    }

    fun runId4(input: String): Pair<Int, Int> {
        var i = 0
        var string = ""
        while (i < input.length && input.substring(i).any { it != '0' }) {
            string += input.substring(i + 1, i + 5)
            if (input[i] == '1') {
                i += 5
            } else {
                i += 5
                break
            }
        }
        return Pair(Integer.parseInt(string, 2), i)
    }

    fun solvePart2() {

    }
}
