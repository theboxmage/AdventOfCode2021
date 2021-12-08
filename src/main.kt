fun main() {
    when (8) {
        1 -> {
            val day1 = Day1("data/day1.txt")
            println("Day 1 Output")
            println("Part 1: \n\t${day1.solvePart1()}")
            println("Part 2: \n\t${day1.solvePart2()}")
        }
        2 -> {
            val day2 = Day2("data/day2.txt")
            println("Day 2 Output")
            println("Part 1: \n\t${day2.solvePart1()}")
            println("Part 2: \n\t${day2.solvePart2()}")
        }
        3 -> {
            val day3 = Day3("data/day3.txt")
            println("Day 3 Output")
            println("Part 1: \n\t${day3.solvePart1()}")
            println("Part 2: \n\t${day3.solvePart2()}")
        }
        4 -> {
            val day4 = Day4("data/day4.txt")
            println("Day 4 Output")
            println("Part 1: \n\t${day4.solvePart1()}")
            println("Part 2: \n\t${day4.solvePart2()}")
        }
        5 -> {
            val day5 = Day5("data/day5.txt")
            println("Day 5 Output")
            println("Part 1: \n\t${day5.solvePart1()}")
            println("Part 2: \n\t${day5.solvePart2()}")
        }
        6 -> {
            val day6 = Day6("data/day6.txt")
            println("Day 6 Output")
            println("Part 1: \n\t${day6.solvePart1()}")
            println("Part 2: \n\t${day6.solvePart2()}")
        }
        7 -> {
            val day7 = Day7("data/day7.txt")
            println("Day 7 Output")
            println("Part 1: \n\t${day7.solvePart1()}")
            println("Part 2: \n\t${day7.solvePart2()}")
        }
        8 -> {
            val day8 = Day8("data/day8.txt")
            println("Day 8 Output")
            println("Part 1: \n\t${day8.solvePart1()}")
            println("Part 2: \n\t${day8.solvePart2()}")
        }
    }
}