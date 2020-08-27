package org.afi.sample.java;

import java.util.ArrayList;
import java.util.List;

// Works, but does not have readonly concept at compile time
public class Immutability {

    public static class Java11 {

        public static void main(String... args) {
            createReadOnlyPerson();
            createImmutablePerson();
        }

        private static void createReadOnlyPerson() {
            var phones = new ArrayList<String>();
            phones.add("11-234-5678");
            phones.add("11-99876-5432");

            var person = new PersonReadOnly("Maria da Silva", phones);
            assert "Maria da Silva".equals(person.fullName);
            assert 2 == person.phones.size();

            phones.add("11-5555-5555");
            assert 2 == person.phones.size();

            person.phones.add("11-6666-6666");
            assert 3 == person.phones.size();
        }

        private static void createImmutablePerson() {
            var phones = new ArrayList<String>();
            phones.add("11-234-5678");
            phones.add("11-99876-5432");

            var person = new PersonImmutable("Maria da Silva", phones);
            assert "Maria da Silva".equals(person.fullName);
            assert 2 == person.phones.size();

            phones.add("11-5555-5555");
            assert 2 == person.phones.size();

            try {
                person.getPhones().add("11-6666-6666");
                assert false;
            } catch (UnsupportedOperationException e) {
                assert e.getMessage() == null;
            }
        }

        private static class PersonReadOnly {
            private final String fullName;
            private final List<String> phones;

            public PersonReadOnly(String fullName, List<String> phones) {
                this.fullName = fullName;
                this.phones = new ArrayList<>(phones);
            }

            public String getFullName() {
                return fullName;
            }

            public List<String> getPhones() {
                return phones;
            }
        }

        private static class PersonImmutable {
            private final String fullName;
            private final List<String> phones;

            public PersonImmutable(String fullName, List<String> phones) {
                this.fullName = fullName;
                this.phones = List.copyOf(phones);
            }

            public String getFullName() {
                return fullName;
            }

            public List<String> getPhones() {
                return phones;
            }
        }
    }

    public static class Java14 {

        public static void main(String... args) {
            createReadOnlyPerson();
            createImmutablePerson();
        }

        private static void createReadOnlyPerson() {
            var phones = new ArrayList<String>();
            phones.add("11-234-5678");
            phones.add("11-99876-5432");

            var person = new PersonReadOnly("Maria da Silva", phones);
            assert "Maria da Silva".equals(person.fullName);
            assert 2 == person.phones.size();

            phones.add("11-5555-5555");
            assert 2 == person.phones.size();

            person.phones.add("11-6666-6666");
            assert 3 == person.phones.size();
        }

        private static void createImmutablePerson() {
            var phones = new ArrayList<String>();
            phones.add("11-234-5678");
            phones.add("11-99876-5432");

            var person = new PersonImmutable("Maria da Silva", phones);
            assert ("Maria da Silva".equals(person.fullName));
            assert (2 == person.phones.size());

            phones.add("11-5555-5555");
            assert (2 == person.phones.size());

            try {
                person.phones.add("11-6666-6666");
                assert false;
            } catch (UnsupportedOperationException e) {
                assert e.getMessage() == null;
            }
        }

        private static record PersonReadOnly(String fullName, List<String> phones) {
            public PersonReadOnly {
                this.fullName = fullName;
                this.phones = new ArrayList<>(phones);
            }
        }

        private static record PersonImmutable(String fullName, List<String> phones) {
            public PersonImmutable {
                this.fullName = fullName;
                this.phones = List.copyOf(phones);
            }
        }
    }
}
