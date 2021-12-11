import kotlin.collections.ArrayList

class Day10(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString().map{it.split("").filter{ i -> i != ""} as ArrayList} as ArrayList
    private val stacks = ArrayList<ArrayList<String>>()
    private val corruptedPoints = mapOf(")" to 3, "]" to 57, "}" to 1197, ">" to 25137)
    private val incompletePoints = mapOf("(" to 1, "[" to 2, "{" to 3, "<" to 4)
    private val sets = mapOf("(" to ")", "{" to "}", "[" to "]", "<" to ">")

    fun solvePart1(): Int {
        var sum = 0
        line@ for(lineIndex in input.size-1 downTo 0) {
            val stack = ArrayList<String>()
            stacks.add(stack)
            for(item in input[lineIndex]) {
                if(sets.containsKey(item)) {
                    stack.add(item)
                } else {
                    val toClose = stack.removeAt(stack.size-1)
                    if(sets[toClose] != item) {
                        sum += corruptedPoints[item]!!
                        input.removeAt(lineIndex)
                        stacks.remove(stack)
                        continue@line
                    }
                }
            }
        }
        return sum
    }

    fun solvePart2(): Long {
        val list = ArrayList<Long>()
        for(line in stacks) {
            var sum = 0L
            for(i in line.reversed()) {
                sum = sum * 5 + incompletePoints[i]!!
            }
            list.add(sum)
        }
        list.sort()
        return list[list.size/2]
    }
}