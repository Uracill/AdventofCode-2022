package Tag12

import java.io.File

private var row = 0
private var col = 0
private var endPosition = IntArray(3)

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag12/Tag12_input.txt").readLines()
    row = input[0].length
    col = input.size
    val grid = Array(col) {CharArray(row)}
    val startPosition = IntArray(3)
    val currentPosition: IntArray
    val stack = mutableListOf<IntArray>()
    for (c in 0 until col) {
        for(r in 0 until row) {
            grid[c][r] = input[c][r]
            if(grid[c][r] == 'S') {
                startPosition[0] = c
                startPosition[1] = r
                grid[c][r] = 'a'
            }
            else if(grid[c][r] == 'E') {
                endPosition[0] = c
                endPosition[1] = r
            }
        }
    }
    currentPosition = startPosition.clone()
    stack.add(currentPosition)
    deepFirstSearch(grid, stack)
    println(endPosition[2]) //462
}

private fun deepFirstSearch(grid: Array<CharArray>, stack: MutableList<IntArray>) {

    var currentPosition = stack.removeFirst()
    while((currentPosition[0] != endPosition[0] || currentPosition[1] != endPosition[1])) {
        val oben = IntArray(3){-1}
        val links = IntArray(3){-1}
        val rechts = IntArray(3){-1}
        val unten = IntArray(3){-1}
        if(currentPosition[0] - 1 >= 0) {
            oben[0] = currentPosition[0] - 1
            oben[1] = currentPosition[1]
            if(istNichtErhalten(stack, oben) && (istNachbar(grid, oben, currentPosition)
                        || istVormEnde(grid, oben, currentPosition))) {  //checks if oben is available
                oben[2] = currentPosition[2] + 1
                stack.add(oben)
            }
        }
        if(currentPosition[1] - 1 >= 0) {
            links[0] = currentPosition[0]
            links[1] = currentPosition[1] - 1
            if(istNichtErhalten(stack, links) && (istNachbar(grid, links, currentPosition)
                        || istVormEnde(grid, links, currentPosition))) {
                links[2] = currentPosition[2] + 1
                stack.add(links)
            }
        }
        if(currentPosition[1] + 1 < row) {
            rechts[0] = currentPosition[0]
            rechts[1] = currentPosition[1] + 1
            if(istNichtErhalten(stack, rechts) && (istNachbar(grid, rechts, currentPosition)
                        || istVormEnde(grid, rechts, currentPosition))) {
                rechts[2] = currentPosition[2] + 1
                stack.add(rechts)
            }
        }
        if(currentPosition[0] + 1 < col) {
            unten[0] = currentPosition[0] + 1
            unten[1] = currentPosition[1]
            if(istNichtErhalten(stack, unten) && (istNachbar(grid, unten, currentPosition)
                        || istVormEnde(grid, unten, currentPosition))) {
                unten[2] = currentPosition[2] + 1
                stack.add(unten)
            }
        }
        grid[currentPosition[0]][currentPosition[1]] = '#'
        currentPosition = stack.removeFirst()
    }
    for (c in 0 until col) {
        for(r in 0 until row) {
            print(grid[c][r])
        }
        println()
    }
    endPosition[2] = currentPosition[2]
    return
}

private fun istNichtErhalten(stack: MutableList<IntArray>, nachbar: IntArray): Boolean {
    val empty = stack.stream().filter { array -> array[0] == nachbar[0] && array[1] == nachbar[1] }.toList().isEmpty()
    return empty
}

private fun istNachbar(grid: Array<CharArray>, nachbar: IntArray, currentPosition: IntArray): Boolean {
    val b1 = grid[nachbar[0]][nachbar[1]] != '#'
    val code = grid[nachbar[0]][nachbar[1]].code
    val code1 = grid[currentPosition[0]][currentPosition[1]].code
    val b2 = code - code1 <= 1 && code != 69
    val b = (b1 && b2)
    return b
}

private fun istVormEnde(grid: Array<CharArray>, nachbar: IntArray, currentPosition: IntArray): Boolean {
    val b1 = grid[nachbar[0]][nachbar[1]] == 'E'
    val b2 = grid[currentPosition[0]][currentPosition[1]] == 'y' || grid[currentPosition[0]][currentPosition[1]] == 'z'
    val b = b1 && b2
    return b
}