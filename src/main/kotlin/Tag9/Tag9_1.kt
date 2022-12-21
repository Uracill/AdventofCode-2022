package Tag9

import java.io.File
import kotlin.math.abs

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag9/Tag9_input.txt").readLines()
    var result = 0
    val grid = Array(1000) { CharArray(1000) }
    val headPosition = IntArray(2)
    headPosition[0] = 500   //Start in etwa in der Mitte
    headPosition[1] = 500
    var tailPosition = IntArray(2)
    tailPosition[0] = 500
    tailPosition[1] = 500
    for(row in 0 until grid.size) {
        for(col in 0 until grid[0].size) {
            grid[row][col] = '.'
        }
    }
    grid[500][500] = '#'
    for(line in input) {
        val command = line.split(" ")[0][0]
        val amount = line.split(" ")[1].toInt()
        for(action in 0 until amount) {
            if(action == 0) {
                if(command == 'U') {
                    headPosition[0]--
                }
                else if(command == 'L') {
                    headPosition[1]--
                }
                else if(command == 'R') {
                    headPosition[1]++
                }
                else {  //D
                    headPosition[0]++
                }
            }
            else {
                val oldHeadPosition = headPosition.clone()
                if(command == 'U') {
                    headPosition[0]--
                }
                else if(command == 'L') {
                    headPosition[1]--
                }
                else if(command == 'R') {
                    headPosition[1]++
                }
                else {  //D
                    headPosition[0]++
                }
                if(abs(headPosition[0]-tailPosition[0]) == 2 || abs(headPosition[1]-tailPosition[1]) == 2
                    || !(abs(headPosition[0]-tailPosition[0]) == 1 && abs(headPosition[1]-tailPosition[1]) == 1)) {
                    tailPosition = oldHeadPosition
                }
                grid[tailPosition[0]][tailPosition[1]] = '#'
            }
        }
    }
    for(row in 0 until grid.size) {
        for(col in 0 until grid[0].size) {
            if(grid[row][col] == '#')
                result++
        }
    }
    println(result) //6285 is too low
}
