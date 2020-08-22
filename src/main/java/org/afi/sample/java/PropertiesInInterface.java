package org.afi.sample.java;

public class PropertiesInInterface {

    // Works, but is not the same thing
    public static class Java11 {

        public static void main(String... args) {
            var car = new Car("Fusca");
            assert car.getName().equals("Fusca");
            assert car.getWheelsQty() == 4;

            var motorcycle = new Motorcycle("Bis");
            assert motorcycle.getName().equals("Bis");
            assert motorcycle.getWheelsQty() == 2;
        }

        public interface Vehicle {
            String getName();

            Integer getWheelsQty();
        }

        public static class Car implements Vehicle {
            private final String name;

            public Car(String name) {
                this.name = name;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public Integer getWheelsQty() {
                return 4;
            }
        }

        public static class Motorcycle implements Vehicle {
            private final String name;

            public Motorcycle(String name) {
                this.name = name;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public Integer getWheelsQty() {
                return 2;
            }
        }
    }

    // Works, hm...
    public static class Java14 {

        public static void main(String... args) {
            var car = new Car("Fusca");
            assert car.name().equals("Fusca");
            assert car.wheelsQty() == 4;

            var motorcycle = new Motorcycle("Bis");
            assert motorcycle.name().equals("Bis");
            assert motorcycle.wheelsQty() == 2;
        }

        public interface Vehicle {
            String name();

            Integer wheelsQty();
        }

        public static record Car(String name) implements Vehicle {

            @Override
            public Integer wheelsQty() {
                return 4;
            }
        }

        public static record Motorcycle(String name) implements Vehicle {

            @Override
            public Integer wheelsQty() {
                return 2;
            }
        }
    }
}
