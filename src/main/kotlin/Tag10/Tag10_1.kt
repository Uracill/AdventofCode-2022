package Tag10

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag10/Tag10_input.txt").readLines()
    var result = 0
    var signalList = mutableListOf<Int>()
    var x = 1
    var clock = 1
    for(command in input) {
        if(command.equals("noop")) {
            clock++
        }
        else {
            val number = command.split(" ")[1].toInt()
            clock++
            if(clock == 20 || clock == 60 || clock == 100
                || clock == 140 || clock == 180 || clock == 220) {
                signalList.add(clock * x)
            }
            clock++
            x += number
        }
        if(clock == 20 || clock == 60 || clock == 100
            || clock == 140 || clock == 180 || clock == 220) {
            signalList.add(clock * x)
        }
    }
    result = signalList.sum()
    println(result) //12460
}
