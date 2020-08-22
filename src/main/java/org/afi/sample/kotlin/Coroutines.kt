package org.afi.sample.kotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        val count = discoverMultiples(2).count()
        println("$count multiples of 2 found")
    }
    launch {
        val count = discoverMultiples(3).count()
        println("$count multiples of 3 found")
    }
    println("Starting...")
}

private fun discoverMultiples(multiple: Int) =
    (1..100)
        .asFlow()
        .filter {
            delay(100)
            it % multiple == 0
        }.onEach {
            println("[${getCurrentThreadName()}] Multiple of $multiple found: $it")
        }

private fun getCurrentThreadName(): String? {
    return Thread.currentThread().name
}
