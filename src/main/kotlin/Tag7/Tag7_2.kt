package Tag7

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag7/Tag7_input.txt").readLines()
    var result = 30000000
    var listing = false
    val sizeOfDirectory = ArrayDeque<Int>()
    var sum = 0
    var neededSpace = 0
    for (command in input) {
        val split = command.split(" ")
        val commandWord = split.get(0)
        val isFile = commandWord.matches(Regex("[0-9]+"))
            if (isFile) {
                sum += commandWord.toInt()
            }
    }
    neededSpace = -40000000 + (sizeOfDirectory.sum() + sum) // 30000000 - 70000000
    for (command in input) {
        val split = command.split(" ")
        val commandWord = split.get(0)
        val ending = split.get(split.lastIndex)
        val isFile = commandWord.matches(Regex("[0-9]+"))
        val isSwitchingDirectory = command.contains("cd")
        val startReading = ending.equals("ls")
        if (isSwitchingDirectory) {
            listing = false
            if (ending.equals("/")) {
                sizeOfDirectory.clear()
                sum = 0
            } else if (ending.equals("..")) {
                if (sum >= neededSpace && sum < result) {
                    result = sum
                }
                sum += sizeOfDirectory.last()
                sizeOfDirectory.removeLast()
            } else {
                sizeOfDirectory.addLast(sum)
                sum = 0
            }
        } else if (startReading) {
            listing = true
        }
        else if (listing) {
            if (isFile) {
                sum = sum + commandWord.toInt()
            }
        }
    }
    if (sum >= neededSpace && sum < result) {
        result = sum
    }
    println(result) //942298
}