import kotlin.system.measureTimeMillis as measureTimeMillis1

fun main() {
    val day13 = Day13("data/day13.txt")
    println("Day 13 Output")
    println("Part 1: \n\t${day13.solvePart1()}")
    println("Part 2: \n\t${day13.solvePart2()}")
}

fun runAll() {
    for (i in 1..12) {
        when (i) {
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
            9 -> {
                val day9 = Day9("data/day9.txt")
                println("Day 9 Output")
                println("Part 1: \n\t${day9.solvePart1()}")
                println("Part 2: \n\t${day9.solvePart2()}")
            }
            10 -> {
                val day10 = Day10("data/day10.txt")
                println("Day 10 Output")
                println("Part 1: \n\t${day10.solvePart1()}")
                println("Part 2: \n\t${day10.solvePart2()}")
            }
            11 -> {
                val day11 = Day11("data/day11.txt")
                println("Day 11 Output")
                println("Part 1: \n\t${day11.solvePart1()}")
                println("Part 2: \n\t${day11.solvePart2()}")
            }
            12 -> {
                val day12 = Day12("data/day12.txt")
                println("Day 12 Output")
                println("Part 1: \n\t${day12.solvePart1()}")
                println("Part 2: \n\t${day12.solvePart2()}")
            }
        }
    }
}

fun Debug() {
    for (i in 1..12) {
        when (i) {
            1 -> {
                val day1 = Day1("data/day1.txt")
                println("Day 1 Output")
                println("Part 1: \t${measureTimeMillis1 { day1.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day1.solvePart2() }} ms")
            }
            2 -> {
                val day2 = Day2("data/day2.txt")
                println("Day 2 Output")
                println("Part 1: \t${measureTimeMillis1 { day2.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day2.solvePart2() }} ms")
            }
            3 -> {
                val day3 = Day3("data/day3.txt")
                println("Day 3 Output")
                println("Part 1: \t${measureTimeMillis1 { day3.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day3.solvePart2() }} ms")
            }
            4 -> {
                val day4 = Day4("data/day4.txt")
                println("Day 4 Output")
                println("Part 1: \t${measureTimeMillis1 { day4.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day4.solvePart2() }} ms")
            }
            5 -> {
                val day5 = Day5("data/day5.txt")
                println("Day 5 Output")
                println("Part 1: \t${measureTimeMillis1 { day5.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day5.solvePart2() }} ms")
            }
            6 -> {
                val day6 = Day6("data/day6.txt")
                println("Day 6 Output")
                println("Part 1: \t${measureTimeMillis1 { day6.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day6.solvePart2() }} ms")
            }
            7 -> {
                val day7 = Day7("data/day7.txt")
                println("Day 7 Output")
                println("Part 1: \t${measureTimeMillis1 { day7.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day7.solvePart2() }} ms")
            }
            8 -> {
                val day8 = Day8("data/day8.txt")
                println("Day 8 Output")
                println("Part 1: \t${measureTimeMillis1 { day8.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day8.solvePart2() }} ms")
            }
            9 -> {
                val day9 = Day9("data/day9.txt")
                println("Day 9 Output")
                println("Part 1: \t${measureTimeMillis1 { day9.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day9.solvePart2() }} ms")
            }
            10 -> {
                val day10 = Day10("data/day10.txt")
                println("Day 10 Output")
                println("Part 1: \t${measureTimeMillis1 { day10.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day10.solvePart2() }} ms")
            }
            11 -> {
                val day11 = Day11("data/day11.txt")
                println("Day 11 Output")
                println("Part 1: \t${measureTimeMillis1 { day11.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day11.solvePart2() }} ms")
            }
            12 -> {
                val day12 = Day12("data/day12.txt")
                println("Day 12 Output")
                println("Part 1: \t${measureTimeMillis1 { day12.solvePart1() }} ms")
                println("Part 2: \t${measureTimeMillis1 { day12.solvePart2() }} ms")
            }
        }
    }
}