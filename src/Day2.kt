class Day2(fileName: String) {
    private val fileService: FileService = FileService(fileName)
    private var h = 0
    private var d = 0
    private var a = 0
    private var instructions = fileService.getLinesAsString()

    private fun setup() {
        h = 0
        d = 0
        a = 0
    }

    fun solvePart1(): Int {
        setup()

        for (instruction in instructions) {
            val (direction, distance) = instruction.split(" ")
            if (direction == "forward") {
                h += Integer.parseInt(distance)
            } else if (direction == "down") {
                d += Integer.parseInt(distance)
            } else if (direction == "up") {
                d -= Integer.parseInt(distance)
            }
        }
        return h * d
    }

    fun solvePart2(): Int {
        setup()

        for (instruction in instructions) {
            val (direction, distance) = instruction.split(" ")
            if (direction == "forward") {
                h += Integer.parseInt(distance)
                d += Integer.parseInt(distance) * a
            } else if (direction == "down") {
                a += Integer.parseInt(distance)
            } else if (direction == "up") {
                a -= Integer.parseInt(distance)
            }
        }
        return h * d
    }
}
