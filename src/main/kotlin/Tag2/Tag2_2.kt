package Tag2

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("./src/main/kotlin/Tag2/Tag2_input.txt").readLines()
    var sum = 0
    var whatToPlay = 0
    var gameResult = 0
    for(game in input) {
        gameResult = when (game.get(2)) {
            'X' -> 0
            'Y' -> 3
            'Z' -> 6
            else -> Int.MAX_VALUE //Kann nicht eintreten
        }
        whatToPlay = when (game.get(0)) {
            'A' -> if(gameResult == 0) 3 else if(gameResult == 3) 1 else 2  //else whatToPlay == 6
            'B' -> if(gameResult == 0) 1 else if(gameResult == 3) 2 else 3
            'C' -> if(gameResult == 0) 2 else if(gameResult == 3) 3 else 1
            else -> Int.MAX_VALUE //Kann nicht eintreten
        }
        sum += whatToPlay + gameResult
    }
    print(sum) //10498
}