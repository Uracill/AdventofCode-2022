package Tag3

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag3/Tag3_input.txt").readLines()
    val resultList = mutableListOf<Int>()
    var index = 0

    for(compartments in input) {
        if(index % 3 == 0) {
            val backpack1 = input.get(index)
            val backpack2 = input.get(index + 1)
            val backpack3 = input.get(index + 2)
            determineSimilarities(backpack1, backpack2, backpack3)?.let { resultList.add(it) }
        }
        index++
    }
    println(resultList.sum()) //2497
}

private fun determineSimilarities(rucksack1: String, rucksack2: String, rucksack3: String): Int? {
    for(item1 in rucksack1) {
        for(item2 in rucksack2)
            for(item3 in rucksack3) {
                if(item1 == item2 && item1 == item3)
                    return charToNumber(item1)
            }
    }
    return null
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


