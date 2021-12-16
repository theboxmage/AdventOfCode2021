import java.util.*

class Day15(filePath: String) {
    private val fileService = FileService(filePath)
    private val input =
        fileService.getLinesAsString().map { it.split("").filter { i -> i != "" }.map { i -> Integer.parseInt(i) } }

    fun solvePart1(): Int {
        return Dijkstra(input)
    }

    fun solvePart2(): Int {
        return Dijkstra(buildSecondInput())
    }

    private fun buildSecondInput(): ArrayList<ArrayList<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        for (i in 0 until input.size * 5) {
            list.add(ArrayList<Int>(input[0].size * 5))
        }
        for (ySum in 0 until 5) {
            for (xSum in 0 until 5) {
                combineLists(xSum, ySum, list)
            }
        }
        return list
    }

    private fun combineLists(x: Int, y: Int, list: ArrayList<ArrayList<Int>>) {
        for (yPrime in input.indices) {
            for (xPrime in input[0].indices) {
                val newValue = input[yPrime][xPrime] + x + y
                list[input.size * y + yPrime].add(if (newValue > 9) newValue - 9 else newValue)
            }
        }
    }

    private fun Dijkstra(input: List<List<Int>>): Int {
        val start = Node(0, 0, 0)
        val queue = PriorityQueue<Node>()
        val map = LinkedHashMap<String, Node>()
        queue.add(start)
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (!map.containsKey(poll.toPair())) {
                map[poll.toPair()] = poll
                val edges = getEdges(poll, input)
                edges.forEach { queue.add(it) }
            }
        }
        return map["${input[0].size - 1} ${input.size - 1}"]!!.distance
    }

    private fun getEdges(curr: Node, input: List<List<Int>>): ArrayList<Node> {
        val list = ArrayList<Node>()
        for (i in -1..1 step 2) {
            if (input.indices.contains(curr.y + i)) {
                list.add(Node(curr.x, curr.y + i, curr.distance + input[curr.y + i][curr.x]))
            }
            if (input[0].indices.contains(curr.x + i)) {
                list.add(Node(curr.x + i, curr.y, curr.distance + input[curr.y][curr.x + i]))
            }
        }
        return list
    }

    class Node(val x: Int, val y: Int, var distance: Int) : Comparable<Node> {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other?.javaClass != javaClass) return false

            other as Node

            return other.x == this.x && other.y == this.y
        }

        override fun toString(): String {
            return "{$x $y: $distance}"
        }

        fun toPair(): String {
            return "$x $y"
        }

        override fun compareTo(other: Node): Int {
            return this.distance - other.distance
        }
    }
}