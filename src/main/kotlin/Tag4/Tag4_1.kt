package Tag4

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag4/Tag4_input.txt").readLines()
    var result = 0

    for(durations in input) {
        val duration1 = durations.split(",").get(0)
        val duration2 = durations.split(",").get(1)
        result += fullyContains(duration1, duration2)
    }
    println(result) //556
}

private fun fullyContains(duration1: String, duration2: String): Int {
    val duration1From = duration1.split("-").get(0).toInt()
    val duration1Until = duration1.split("-").get(1).toInt()
    val duration2From = duration2.split("-").get(0).toInt()
    val duration2Until = duration2.split("-").get(1).toInt()
    if(duration1From <= duration2From && duration1Until >= duration2Until) {
        return 1
    }
    else if(duration2From <= duration1From && duration2Until >= duration1Until) {
        return 1
    }
    return 0
}
