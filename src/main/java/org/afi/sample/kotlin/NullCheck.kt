package org.afi.sample.kotlin

fun main() {
    val fullName = concatName("José", "Silva")
    assert(fullName == "José Silva")

    // concatName("José", null) //Don`t compile

    nullAutomaticCasts("foo")
}

fun concatName(firstName: String, lastName: String) = "$firstName $lastName"

fun nullAutomaticCasts(inputString: String?) {
    if (inputString != null) {
        val str: String = inputString
        assert(str == inputString)
    } else {
        // val str: String = inputString //Don`t compile
    }
}
