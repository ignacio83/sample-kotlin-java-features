package org.afi.sample.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Works, but does not have readonly concept
public class Immutability {

    public static void main(String... args) {
        createImmutablePerson();
    }

    public static void createImmutablePerson() {
        var phones = new ArrayList<String>();
        phones.add("11-234-5678");
        phones.add("11-99876-5432");

        var person = new PersonImmutable("Maria da Silva", phones);
        // person.phones += "11-5555-5555" //Don`t compile
        assert ("Maria da Silva".equals(person.fullName));
        assert (2 == person.phones.size());

        phones.add("11-5555-5555");
        assert (2 == person.phones.size());

        try {
            person.getPhones().add("11-6666-6666");
            assert false;
        } catch (UnsupportedOperationException e) {
            assert "".equals(e.getMessage());
        }
    }

    public static class PersonImmutable {
        private final String fullName;
        private final List<String> phones;

        public PersonImmutable(String fullName, List<String> phones) {
            this.fullName = fullName;
            this.phones = Collections.unmodifiableList(phones);
        }

        public String getFullName() {
            return fullName;
        }

        public List<String> getPhones() {
            return phones;
        }
    }
}
