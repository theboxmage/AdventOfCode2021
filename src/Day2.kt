class Day2(fileName: String) {
    private val fileService: FileService = FileService(fileName)
    var h = 0
    var d = 0
    var a = 0
    lateinit var instructions: List<String>

    private fun setup() {
        h = 0
        d = 0
        a = 0
        instructions = fileService.getLinesAsString()
    }

    fun solvePart1(): String {
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
        return "\tHorizontal: $h Distance: $d \n\tH*D:${h * d}"
    }

    fun solvePart2(): String {
        setup()

        for (instruction in instructions) {
            val (direction, distance) = instruction.split(" ")
            when (direction) {
                "forward" -> {
                    h += Integer.parseInt(distance)
                    d += Integer.parseInt(distance) * a
                }
                "down" -> {
                    a += Integer.parseInt(distance)
                }
                "up" -> {
                    a -= Integer.parseInt(distance)
                }
            }
        }
        return "\tHorizontal: $h Distance: $d \n\tH*D:${h * d}"
    }
}
