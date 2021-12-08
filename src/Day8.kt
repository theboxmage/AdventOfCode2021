import java.util.stream.Collectors

class Day8(filePath: String) {
    private val fileService = FileService(filePath)
    private val input = fileService.getLinesAsString()

    fun solvePart1(): Int {
        var count = 0
        for (line in input) {
            val numbers = LinkedHashMap<Int, String>()
            val (template, output) = line.split("|").map {
                it.trim().split(" ").map { i -> i.split("").toList().sorted().stream().collect(Collectors.joining()) }
            }
            parseTemplate(template, numbers)
            count += output.count { numbers.containsValue(it) }
        }
        return count
    }

    private fun parseTemplate(template: List<String>, numbers: LinkedHashMap<Int, String>) {
        for (item in template) {
            if (item.length == 2) {
                numbers[1] = item
            }
            else if (item.length == 3) {
                numbers[7] = item
            }
            else if (item.length == 4) {
                numbers[4] = item
            }
            else if (item.length == 7) {
                numbers[8] = item
            }
        }
    }

    fun solvePart2(): Long {
        var count = 0L
        for (line in input) {
            val (template, output) = line.split("|").map {
                it.trim().split(" ").map { i -> i.split("").toList().sorted().stream().collect(Collectors.joining()) }
            }
            val numbers = LinkedHashMap<Int, String>()
            parseTemplate(template, numbers)
            for (item in template) {
                if (!numbers.containsValue(item)) {
                    if (item.length == 5) {
                        if (intersection(item, numbers[1]!!) == 2) {
                            numbers[3] = item
                        }
                    }
                    else if (item.length == 6) {
                        if (intersection(item, numbers[4]!!) == 4) {
                            numbers[9] = item
                        } else if (intersection(item, numbers[1]!!) == 1) {
                            numbers[6] = item
                        } else {
                            numbers[0] = item
                        }
                    }
                }
            }
            for (item in template) {
                if (!numbers.containsValue(item)) {
                    if (item.length == 5) {
                        if (intersection(item, numbers[6]!!) == 4) {
                            numbers[2] = item
                        } else {
                            numbers[5] = item
                        }
                    }
                }
            }

            val reversed = numbers.entries.associate { (k, v) -> v to k }
            count += output.map { reversed[it].toString() }.stream().collect(Collectors.joining()).toInt()
        }
        return count
    }

    private fun intersection(string1: String, string2: String): Int {
        return string1.split("").intersect(string2.split("")).filter { it != "" }.size
    }
}