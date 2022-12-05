package Tag5

import java.io.File
import kotlin.collections.ArrayDeque

fun main(args: Array<String>): Unit {
    var input = File("src/main/kotlin/Tag5/Tag5_input.txt").readLines()
    input = input.subList(10, input.size)
    var result = ""
    val stackList = mutableListOf(
        ArrayDeque(mutableListOf('W', 'D', 'G', 'B', 'H', 'R', 'V')),
        ArrayDeque(mutableListOf('J', 'N', 'G', 'C', 'R', 'F')),
        ArrayDeque(mutableListOf('L', 'S', 'F', 'H', 'D', 'N', 'J')),
        ArrayDeque(mutableListOf('J', 'D', 'S', 'V')),
        ArrayDeque(mutableListOf('S', 'H', 'D', 'R', 'Q', 'W', 'N', 'V')),
        ArrayDeque(mutableListOf('P', 'G', 'H', 'C', 'M')),
        ArrayDeque(mutableListOf('F', 'J', 'B', 'G', 'L', 'Z', 'H', 'C')),
        ArrayDeque(mutableListOf('S', 'J', 'R')),
        ArrayDeque(mutableListOf('L', 'G', 'S', 'R', 'B', 'N', 'V', 'M')))
    for(move in input) {
        val number = move.split("move ").get(1).split(" from").get(0).toInt()
        val from = move.split("from ").get(1).split(" to").get(0).toInt() - 1
        val to = move.split("to ").get(1).toInt() - 1
        for(i in number downTo 1) {
            val stackItem = stackList.get(from).removeLast()
            stackList.get(to).addLast(stackItem)
        }
    }
    for(last in stackList) {
        result = result + last.last()
    }
    println(result) //JRVNHHCSJ
}