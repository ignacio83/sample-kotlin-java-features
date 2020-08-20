package org.afi.sample.java;

import java.util.function.Function;

public class HigherOrderFunctions {

    public static void main(String... args) {
        var userDTO = findUserById(10,
                it -> new UserDTO(it.id, it.name)
        );
        assert userDTO.id == 10;

        var secretQuestionDTO = findUserByIdWithGenerics(20,
                it -> new SecretQuestionDTO(it.login, it.secretQuestion));

        assert (secretQuestionDTO.login.equals("jesse"));
        assert (secretQuestionDTO.secretQuestion.equals("What is your favorite phrase?"));
    }

    public static UserDTO findUserById(Integer id, Function<User, UserDTO> mapper) {
        var user = new User(id,
                "jesse",
                "Jesse Pinkman",
                "What is your favorite phrase?",
                "Yeah Mr. White! Yeah Science.");
        return mapper.apply(user);
    }

    public static <T> T findUserByIdWithGenerics(Integer id, Function<User, T> mapper) {
        var user = new User(id,
                "jesse",
                "Jesse Pinkman",
                "What is your favorite phrase?",
                "Yeah Mr. White! Yeah Science.");
        return mapper.apply(user);
    }

    public static record User(Integer id, String login, String name, String secretQuestion, String secretAnswer) {
    }

    public static record UserDTO(Integer id, String name) {
    }

    public static record SecretQuestionDTO(String login, String secretQuestion) {
    }
}
