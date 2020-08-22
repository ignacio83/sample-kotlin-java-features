package org.afi.sample.kotlin

fun main() {
    val userDTO = findUserById(10) {
        UserDTO(it.id, it.name)
    }
    assert(userDTO.id == 10)

    val secretQuestionDTO = findUserByIdWithGenerics(20) {
        SecretQuestionDTO(it.login, it.secretQuestion)
    }
    assert(secretQuestionDTO.login == "jesse")
    assert(secretQuestionDTO.secretQuestion == "What is your favorite phrase?")
}

fun findUserById(id: Int, mapper: (User) -> UserDTO): UserDTO {
    val user = User(
        id,
        "jesse",
        "Jesse Pinkman",
        "What is your favorite phrase?",
        "Yeah Mr. White! Yeah Science."
    )
    return mapper(user)
}

fun <T> findUserByIdWithGenerics(id: Int, mapper: (User) -> T): T {
    val user = User(
        id,
        "jesse",
        "Jesse Pinkman",
        "What is your favorite phrase?",
        "Yeah Mr. White! Yeah Science."
    )
    return mapper(user)
}

class User(val id: Int, val login: String, val name: String, val secretQuestion: String, val secretAnswer: String)

class UserDTO(val id: Int, val name: String)

class SecretQuestionDTO(val login: String, val secretQuestion: String)
