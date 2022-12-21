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
            var treeUpValue = 0
            var treeLeftValue = 0
            var treeDownValue = 0
            var treeRightValue = 0
            for(scenicUp in treeUp.size - 1 downTo 0) {
                treeUpValue++
                if(treeUp[scenicUp] >= tree) {
                    break
                }
            }
            for(scenicLeft in treeLeft.size - 1 downTo 0) {
                treeLeftValue++
                if(treeLeft[scenicLeft] >= tree) {
                    break
                }
            }
            for(scenicDown in 0 until treeDown.size) {
                treeDownValue++
                if(treeDown[scenicDown] >= tree) {
                    break
                }
            }
            for(scenicRight in 0 until treeRight.size) {
                treeRightValue++
                if(treeRight[scenicRight] >= tree) {
                    break
                }
            }
            val scenicScore = treeUpValue * treeLeftValue * treeDownValue * treeRightValue
            if(scenicScore > result) {
                result = scenicScore
            }
        }
    }
    println(result) //368368
}
