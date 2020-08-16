package org.afi.sample.kotlin

import java.io.IOException
import java.text.SimpleDateFormat
import org.afi.sample.java.NullCheck

fun main() {
    NullCheck.main()

    // No more checked exceptions
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    val date = dateFormat.parse("01/01/2020")
    assert(date != null)

    // CallingKotlin.receivesNotNullParameter(null) // Do not compile
}

@Throws(IOException::class)
fun throwIOException() {
    throw IOException()
}
