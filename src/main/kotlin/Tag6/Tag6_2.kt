package Tag6

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag6/Tag6_input.txt").readText()
    var result = 0
    val numberOfDifferentChars = 14
    for (i in numberOfDifferentChars until input.length) {
        if(result == 0)
            for(j in i - numberOfDifferentChars until i) {
                if(areAllDifferent(input.substring(j, i)))
                    result = i
                break
            }
        else {
            break
        }
    }
    println(result) //1953
}

private fun areAllDifferent(substring: String): Boolean {
    var different = true
    for(i in 0 until substring.length) {
        if(different) {
            for(j in i + 1 until substring.length) {
                if(substring.get(i) == substring.get(j))
                    different = false
            }
        }
        else {
            break
        }
    }
    return different
}