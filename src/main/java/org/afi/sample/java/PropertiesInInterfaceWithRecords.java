package org.afi.sample.java;

// Works, but it stinks
public class PropertiesInInterfaceWithRecords {

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
