fun main() {
    val line = "3"
    when(line){
        "1" -> {
            val day1 = Day1("data/day1.txt")
            println("Day 1 Output")
            println("Part 1: \n${day1.solvePart1()}")
            println("Part 2: \n${day1.solvePart2()}")
        }
        "2" -> {
            val day2 = Day2("data/day2.txt")
            println("Day 2 Output")
            println("Part 1: \n${day2.solvePart1()}")
            println("Part 2: \n${day2.solvePart2()}")
        }
        "3" -> {
            val day3 = Day3("data/day3.txt")
            println("Day 3 Output")
            println("Part 1: \n\t${day3.solvePart1()}")
            println("Part 2: \n\t${day3.solvePart2()}")
        }
    }
}