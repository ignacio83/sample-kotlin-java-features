package org.afi.sample.kotlin

fun main() {
    val car = Car("Fusca")
    assert(car.wheelsQty == 4)

    val motorcycle = Motorcycle("Bis")
    assert(motorcycle.wheelsQty == 2)
}

interface Vehicle {
    val name: String
    val wheelsQty: Int
}

class Car(override val name: String) : Vehicle {
    override val wheelsQty = 4
}

class Motorcycle(override val name: String) : Vehicle {
    override val wheelsQty = 2
}
