package org.afi.sample.kotlin

fun main() {
    val fullName = concatName("José", null, "Silva")
    assert(fullName == "José Silva")

    // concatName("José", null, null) //Don`t compile

    nullAutomaticCasts("foo")
}

fun concatName(firstName: String, middleName: String?, lastName: String) =
    "$firstName ${middleName ?: ""} $lastName"

fun nullAutomaticCasts(inputString: String?) {
    if (inputString != null) {
        val str: String = inputString
        assert(str == inputString)
    } else {
        // val str: String = inputString //Don`t compile
    }
}
