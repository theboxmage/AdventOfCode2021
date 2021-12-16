import java.util.*

class Day15(filePath: String) {
    private val fileService = FileService(filePath)
    private val input =
        fileService.getLinesAsString().map { it.split("").filter { i -> i != "" }.map { i -> Integer.parseInt(i) } }

    fun solvePart1() {
        Dijkstra()
    }

    fun solvePart2() {

    }

    fun Dijkstra() {
        val start = Node(0, 0, 0)
        val queue = PriorityQueue<Node>()
        println(getEdges(start))
    }

    fun getEdges(curr: Node): ArrayList<Node> {
        val list = ArrayList<Node>()
        for(i in -1..1 step 2) {
            if(this.input.indices.contains(curr.y+i)){
                list.add(Node(curr.x, curr.y+i,curr.distance + this.input[curr.y+i][curr.x]))
            }
            if(this.input[0].indices.contains(curr.x+i)) {
                list.add(Node(curr.x+i, curr.y, curr.distance + this.input[curr.y][curr.x+i]))
            }
        }
        return list
    }

    class Node(val x: Int, val y: Int, var distance: Int){

        override fun equals(other: Any?): Boolean {
            if (this===other) return true
            if (other?.javaClass != javaClass) return false

            other as Node

            return other.x == this.x && other.y == this.y
        }

        override fun toString(): String {
            return "{$x $y: $distance}"
        }
    }

}
