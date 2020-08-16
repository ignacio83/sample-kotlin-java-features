package org.afi.sample.kotlin

import java.util.Base64

fun main() {
    val text = "Plain text"
    val base64Encoded = text.encodeToBase64()
    assert(base64Encoded == "UGxhaW4gdGV4dA==")

    val decodeFromBase64 = base64Encoded.decodeFromBase64()
    assert(decodeFromBase64 == "Plain text")
}

fun String.encodeToBase64(): String = Base64.getEncoder().encodeToString(this.toByteArray())

fun String.decodeFromBase64(): String = String(Base64.getDecoder().decode(this))
