package Tag7

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag7/Tag7_input.txt").readLines()
    var result = 0
    var listing = false
    val sizeOfDirectory = ArrayDeque<Int>()
    var sum = 0
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
                sum = 0
            } else if (ending.equals("..")) {
                if (sum <= 100000) {
                    result += sum
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
    println(result) //1443806
}