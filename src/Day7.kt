import kotlin.math.abs

class Day7(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getFirstLineAsString().split(",").map { Integer.parseInt(it) }

    fun solvePart1(): Int {
        return input.map { input.sumOf { i -> abs(i - it) } }.minOf{it}
    }

    fun solvePart2(): Int {
        return (input.minOf{it}..input.maxOf{it}).minOf{i -> input.sumOf{(0..abs(it-i)).sum()}}
    }
}