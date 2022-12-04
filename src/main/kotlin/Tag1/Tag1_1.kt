package Tag1

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("./src/main/kotlin/Tag1/Tag1_input.txt").readLines()
    val newList = mutableListOf<Int>()
    var sum = 0

    for(number in input) {
        if(!number.equals("")) {
            sum += number.toInt()
        }
        else {
            newList.add(sum)
            sum = 0
        }
    }
    println(newList.max()) //67450
}