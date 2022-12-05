package Tag3

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag3/Tag3_input.txt").readLines()
    val resultList = mutableListOf<Int>()

    for(compartments in input) {
        val compartment1 = compartments.substring(0, compartments.length/2)
        val compartment2 = compartments.substring(compartments.length/2, compartments.length)
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
    return null    //Tritt nie ein
}

private fun charToNumber(char: Char): Int {
    val result = char.code
    if(result >= 97) {  //char ist ein Kleinbuchstabe
        return result - 96
    }
    else {  //char ist ein Großbuchstabe
        return result - 38
    }
}
