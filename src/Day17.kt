import kotlin.math.max

class Day17(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = "-?\\d+".toRegex().findAll(fileService.getFirstLineAsString()).toList().map{Integer.parseInt(it.value)}
    var maxY = 0
    var count = 0
    val xGoal = input[0]..input[1]
    val yGoal = input[2]..input[3]
    fun solvePart1(): Int {
        for(x in -500..500) {
            for(y in -500..500) {
                sendProbe(x, y)
            }
        }
        return maxY
    }

    private fun sendProbe(xPrime: Int, yPrime: Int) {
        var x = 0
        var y = 0
        var maxYIter = 0
        var xVelocity = xPrime
        var yVelocity = yPrime
        while((0..xGoal.last).contains(x) && y >= yGoal.first && !(xGoal.contains(x) && yGoal.contains(y))) {
            x += xVelocity
            y += yVelocity
            if(xVelocity != 0) {
                xVelocity += if(xVelocity > 0) -1 else 1
            }
            maxYIter = max(maxYIter, y)
            yVelocity--
        }
        if(xGoal.contains(x) && yGoal.contains(y)) {
            count++
            maxY = max(maxY, maxYIter)
        }
    }

    fun solvePart2(): Int {
        return count
    }
}
