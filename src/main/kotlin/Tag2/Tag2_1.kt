package Tag2

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("./src/main/kotlin/Tag2/Tag2_input.txt").readLines()
    var sum = 0
    var opponent = 0
    var player = 0
    for(game in input) {
        opponent = when (game.get(0)) {
            'A' -> 1
            'B' -> 2
            'C' -> 3
            else -> Int.MAX_VALUE //Kann nicht eintreten
        }
        player = when (game.get(2)) {
            'X' -> if(opponent == 1) 3 else if(opponent == 2) 0 else 6 //else opponent == 3
            'Y' -> if(opponent == 1) 6 else if(opponent == 2) 3 else 0
            'Z' -> if(opponent == 1) 0 else if(opponent == 2) 6 else 3
            else -> Int.MAX_VALUE //Kann nicht eintreten
        }
        sum += opponent + player
    }
    print(sum) //15673
}