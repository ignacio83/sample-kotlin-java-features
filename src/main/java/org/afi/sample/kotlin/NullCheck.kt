package org.afi.sample.kotlin

fun main() {
    val fullName = concatName("José", "Silva")
    assert(fullName == "José Silva")

    // concatName("José", null) //Don`t compile
}

fun concatName(firstName: String, lastName: String) = "$firstName $lastName"
