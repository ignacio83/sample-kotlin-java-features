package org.afi.sample.kotlin

fun main() {
    sequenceSample()
    groupBySample()
    binarySearch()
    setOperations()
}

fun sequenceSample() {
    val allNumbers = generateSequence(1) { it + 1 }
    val divisibleByThree = allNumbers
        .filter { it % 3 == 0 }
        .map(Int::toString)
        .take(3)

    val list = divisibleByThree.toList()

    assert(list[0] == "3")
    assert(list[1] == "6")
    assert(list[2] == "9")

    assert(list.count() == 3)
    println("First three multiples: $list")

    val last = allNumbers
        .take(3)
        .findLast { it % 3 == 0 }

    assert(last == 9)
    println("Third multiple of three: $last")
}

fun groupBySample() {
    val phrase = "Both Kotlin and Java are Islands"
    val map = phrase.split(" ").groupBy(String::length)

    assert(map[3]!!.containsAll(setOf("and", "are")))
    assert(map[6]!!.contains("Kotlin"))
    println("Group by length: $map")
}

fun binarySearch() {
    val numbers = mutableListOf(42, 8, 23, 16, 15, 4)
    numbers.sort()

    println("Ordered numbers: $numbers")

    assert(numbers.binarySearch(40) < 0)
    assert(numbers.binarySearch(8) > 0)
    assert(numbers.binarySearch(42) > 0)
}

fun setOperations() {
    val fruits = setOf("orange", "apple", "banana")
    val colors = setOf("orange", "red", "yellow")

    val intersection = fruits intersect colors
    println("Intersection: $intersection")
    assert(intersection.size == 1)
    assert(intersection.contains("orange"))

    val all = fruits union colors
    println("Union: $all")
    assert(all.size == 5)

    val onlyFruits = fruits subtract colors
    println("Only fruits: $onlyFruits")
    assert(onlyFruits.size == 2)
}