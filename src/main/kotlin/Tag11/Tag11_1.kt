package Tag11

import java.io.File
import java.lang.Math.round

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag11/Tag11_input.txt").readLines()
    val constructApe = mutableListOf<String>()
    val apeList = mutableListOf<Monkey>()
    val numberOfRounds = 20
    val roundList = mutableListOf<Long>()
    val resultList = mutableListOf<Long>()
    for(line in input) {
        if(line.equals("")) {
            addMonkeyToList(apeList, constructApe)
        }
        else {
            constructApe.add(line)
        }
    }
    addMonkeyToList(apeList, constructApe)

    for(i in 0 until apeList.size) {    //initiate roundList with 0
        roundList.add(i, 0)
    }

    for(round in 0 until numberOfRounds) {
        for(ape in apeList) {
            roundList.set(ape.number, roundList[ape.number] + ape.itemList.size)
            while(ape.itemList.isNotEmpty()) {
                val item = ape.itemList.removeFirst()
                var operand2 = 0L
                if(ape.operationList[2].equals("old")) {
                    operand2 = item
                }
                else {
                    operand2 = ape.operationList[2].toLong()
                }
                val operation = ape.operationList[1]
                var new = item
                if(operation.equals("+")) {
                    new += operand2
                }
                else {
                    new *= operand2
                }
                new = round((new / 3).toDouble())
                if(new % ape.test == 0L) {
                    apeList[ape.conditionList[0].toInt()].itemList.addLast(new)
                }
                else {
                    apeList[ape.conditionList[1].toInt()].itemList.addLast(new)
                }
            }
        }
    }

    resultList.add(roundList.removeAt(roundList.indexOf(roundList.max())))
    resultList.add(roundList.removeAt(roundList.indexOf(roundList.max())))
    println(resultList[0] * resultList[1])  //99852
}

private fun addMonkeyToList(
    apeList: MutableList<Monkey>,
    constructApe: MutableList<String>
) {
    apeList.add(erstelleApe(constructApe))
    constructApe.clear()
}

private fun erstelleApe(constructApe: MutableList<String>): Monkey {
    val number = constructApe[0].split(" ")[1][0].digitToInt()
    val startingItems = constructApe[1].split(" Starting items: ")[1]
    val itemList = startingItems.split(", ").map { s: String ->  s.toLong()}.toCollection(ArrayDeque())
    val operation = constructApe[2].split("Operation: new = ")[1]
    val operationList = operation.split(" ").toList()
    val test = constructApe[3].split("Test: divisible by ")[1].toLong()
    val conditionList = mutableListOf<Long>()
    conditionList.add(constructApe[4].split("monkey ")[1].toLong())
    conditionList.add(constructApe[5].split("monkey ")[1].toLong())
    return Monkey(number, itemList, operationList, test, conditionList)
}

data class Monkey(val number: Int, var itemList: ArrayDeque<Long>,
                          val operationList: List<String>, val test: Long, val conditionList: MutableList<Long>) {
}