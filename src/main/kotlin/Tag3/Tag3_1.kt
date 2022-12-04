package Tag3

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag3/Tag3_input.txt").readLines()
    val resultList = mutableListOf<Int>()

    for(compartments in input) {
        var compartment1 = compartments.substring(0, compartments.length/2)
        var compartment2 = compartments.substring(compartments.length/2, compartments.length)
        determineSimilarities(compartment1, compartment2)?.let { resultList.add(it) }
    }
    println(resultList.sum()) //7872
}

private fun determineSimilarities(compartment1: String, compartments2: String): Int? {
    for(char1 in compartment1) {
        for(char2 in compartments2)
            if(char1 == char2) {
                return charToNumber(char1)
            }
    }
    return null
}

private fun charToNumber(char: Char): Int? {
    return when(char) {
        'a' -> 1
        'b' -> 2
        'c' -> 3
        'd' -> 4
        'e' -> 5
        'f' -> 6
        'g' -> 7
        'h' -> 8
        'i' -> 9
        'j' -> 10
        'k' -> 11
        'l' -> 12
        'm' -> 13
        'n' -> 14
        'o' -> 15
        'p' -> 16
        'q' -> 17
        'r' -> 18
        's' -> 19
        't' -> 20
        'u' -> 21
        'v' -> 22
        'w' -> 23
        'x' -> 24
        'y' -> 25
        'z' -> 26
        'A' -> 27
        'B' -> 28
        'C' -> 29
        'D' -> 30
        'E' -> 31
        'F' -> 32
        'G' -> 33
        'H' -> 34
        'I' -> 35
        'J' -> 36
        'K' -> 37
        'L' -> 38
        'M' -> 39
        'N' -> 40
        'O' -> 41
        'P' -> 42
        'Q' -> 43
        'R' -> 44
        'S' -> 45
        'T' -> 46
        'U' -> 47
        'V' -> 48
        'W' -> 49
        'X' -> 50
        'Y' -> 51
        'Z' -> 52
        else -> null
    }
}
