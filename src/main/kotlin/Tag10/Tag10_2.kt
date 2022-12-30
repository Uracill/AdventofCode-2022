package Tag10

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag10/Tag10_input.txt").readLines()
    var result = 0
    var signalList = Array(6) { CharArray(40) }
    var x = 1
    var clock = 1
    for(command in input) {
        if(command.equals("noop")) {
            drawSignal(signalList, clock, x)
            clock++
        }
        else {
            val number = command.split(" ")[1].toInt()
            drawSignal(signalList, clock, x)
            clock++
            drawSignal(signalList, clock, x)
            x += number
            clock++
        }
    }
    for(col in 0 until 6) {
        for(row in 0 until 40) {
            print(signalList[col][row])
        }
        println()
    }
    //EZFPRAKL
}

fun drawSignal(signalList: Array<CharArray>, clock: Int, x: Int) {
    if((clock - 1) % 40 == x - 1 || (clock - 1) % 40 == x || (clock - 1) % 40 == x + 1) {
        signalList[(clock - 1) / 40][(clock - 1) % 40] = '#'
    }
    else {
        signalList[(clock - 1) / 40][(clock - 1) % 40] = '.'
    }
}
