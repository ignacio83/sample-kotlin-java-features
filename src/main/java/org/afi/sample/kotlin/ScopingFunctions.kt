package org.afi.sample.kotlin

fun main() {
    // Simple
    findFullName()?.let {
        assert(it == "José da Silva")
    }

    // Complex
    findPerson()
        .apply {
            fullName = "Jonas Souza"
            phone = "11-2345678"
            zipCode = "11111"
        }
        .let(::savePerson)
        .also {
            assert(it.fullName == "Jonas Souza")
        }
}

fun findFullName(): String? {
    return "José da Silva"
}

fun findPerson() = Person(1, "José da Silva", "11-98765432", "22222")

fun savePerson(person: Person): Person {
    print("Person ${person.fullName} saved")
    return person
}

class Person(val id: Int, var fullName: String, var phone: String, var zipCode: String)
