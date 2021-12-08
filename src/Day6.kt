class Day6(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getFirstLineAsString().split(",").map { it.toInt() }
    private val fish = ArrayList<Long>(arrayOf(0L,0L,0L,0L,0L,0L,0L,0L,0L).asList())

    fun solvePart1(): Long {
        input.forEach { fish[it]++}
        for(i in 0 until 80) {
            runDay(fish)
        }
        return fish.sum()
    }

    fun solvePart2(): Long {
        for(i in 0 until 176) {
            runDay(fish)
        }
        return fish.sum()
    }

    private fun runDay(fish: ArrayList<Long>) {
        val newFish = fish.removeAt(0)
        fish[6] = fish[6] + newFish
        fish.add(newFish)
    }
}
