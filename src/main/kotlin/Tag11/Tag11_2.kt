package Tag11

import java.io.File

fun main(args: Array<String>): Unit {
    val input = File("src/main/kotlin/Tag11/Tag11_input.txt").readLines()
    val constructApe = mutableListOf<String>()
    val apeList = mutableListOf<Monkey>()
    var roundNumber = 1
    val numberOfRounds = 10000
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

    for(ape in apeList) {    //initiate roundList with 0
        roundList.add(0, 0)
        roundNumber *= ape.test.toInt()
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
                new = new % roundNumber
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
    println(resultList[0] * resultList[1])  //25935263541
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