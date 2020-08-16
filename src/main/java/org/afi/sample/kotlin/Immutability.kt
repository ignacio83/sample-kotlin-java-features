package org.afi.sample.kotlin

fun main() {
    createReadOnlyPerson()
    createImmutablePerson()
}

fun createReadOnlyPerson() {
    val phones = ArrayList<String>()
    phones += "11-234-5678"
    phones += "11-99876-5432"

    val person = PersonReadOnly("Maria da Silva", phones)
    // person.phones += "11-5555-5555" //Don`t compile
    assert("Maria da Silva" == person.fullName)
    assert(2 == person.phones.size)

    phones += "11-5555-5555"
    assert(3 == person.phones.size)

    (person.phones as MutableList<String>) += "11-6666-6666"
    assert(4 == person.phones.size)
}

fun createImmutablePerson() {
    val phones = ArrayList<String>()
    phones += "11-234-5678"
    phones += "11-99876-5432"

    val person = PersonImmutable("Maria da Silva", phones)
    // person.phones += "11-5555-5555" //Don`t compile
    assert("Maria da Silva" == person.fullName)
    assert(2 == person.phones.size)

    phones += "11-5555-5555"
    assert(2 == person.phones.size)

    val success = runCatching {
        (person.phones as MutableList<String>) += "11-6666-6666"
    }.isFailure

    assert(!success)
}

class PersonReadOnly(val fullName: String, val phones: List<String>)

class PersonImmutable(val fullName: String, phones: List<String>) {
    val phones = listOf(*phones.toTypedArray())
}
