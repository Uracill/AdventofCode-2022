package Tag8

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag8/Tag8_input.txt").readLines()
    var result = 0 //Number of visible Trees
    val row = input[0].length
    val col = input.size
    val treeArray = Array(row) { IntArray(col) }
    for(r in 0 until row) {
        for(c in 0 until col) {
            treeArray[r][c] = input[r][c].digitToInt()
        }
    }
    for(i in 0 until row) {
        for(j in 0 until col) {
            val tree = treeArray[i][j]
            if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                result++
            }
            else {
                val treeUp = IntArray(i)
                for(rowUp in 0 until i) {
                    treeUp[rowUp] = treeArray[rowUp][j]
                }
                val treeLeft = IntArray(j)
                for(colLeft in 0 until j) {
                    treeLeft[colLeft] = treeArray[i][colLeft]
                }
                val treeDown = IntArray(row - i - 1)
                for(rowDown in i + 1 until row) {
                    treeDown[rowDown - (i + 1)] = treeArray[rowDown][j]
                }
                val treeRight = IntArray(col - j - 1)
                for(colLeft in j + 1 until col) {
                    treeRight[colLeft - (j + 1)] = treeArray[i][colLeft]
                }
                val treeUpValue = treeUp.max()
                val treeLeftValue = treeLeft.max()
                val treeDownValue = treeDown.max()
                val treeRightValue = treeRight.max()
                if(tree > treeUpValue || tree > treeLeftValue || tree > treeDownValue || tree > treeRightValue) {
                    result++
                }
            }
        }
    }
    println(result) //1818
}
