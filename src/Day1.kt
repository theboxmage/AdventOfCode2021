class Day1(fileName: String) {
    private val fileService = FileService(fileName)
    private val lines = fileService.getLinesAsInt()

    fun solvePart1(): String {
        var count = 0
        for (i in 0..lines.size - 2) {
            count += if (lines[i] < lines[i + 1]) 1 else 0
        }
        return "\tCount: $count"
    }

    fun solvePart2(): String {
        var count = 0
        for (i in 0..lines.size-4) {
            val num1 = lines[i] + lines[i+1] + lines[i+2]
            val num2 = lines[i+1] + lines[i+2] + lines[i+3]
            count += if (num1 < num2) 1 else 0
        }
        return "\tCount: $count"
    }
}
