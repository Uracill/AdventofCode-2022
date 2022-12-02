package Tag1

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("./src/main/kotlin/Tag1/Tag1_input.txt").readLines()
    var sum = 0
    var firstBiggestValue = 0
    var secondBiggestValue = 0
    var thirdBiggestValue = 0

    for(number in input) {
        if(!number.equals("")) {
            sum += number.toInt()
        }
        else {
            if(sum > firstBiggestValue) {
                thirdBiggestValue = secondBiggestValue
                secondBiggestValue = firstBiggestValue
                firstBiggestValue = sum
            }
            else if(sum > secondBiggestValue) {
                thirdBiggestValue = secondBiggestValue
                secondBiggestValue = sum
            }
            else if(sum > thirdBiggestValue) {
                thirdBiggestValue = sum
            }
            sum = 0
        }
    }
    print(firstBiggestValue + secondBiggestValue + thirdBiggestValue) //199357
}