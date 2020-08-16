package org.afi.sample.java;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsAPI {

    public static void main(String... args) {
        sequenceSample();
        groupBySample();
        binarySearch();
        setOperations();
    }

    public static void sequenceSample() {
        // Not supported
    }

    public static void groupBySample() {
        var phrase = "Both Kotlin and Java are Islands";
        var map = Arrays.stream(phrase.split(" "))
                .collect(Collectors.groupingBy(String::length));

        assert map.get(3).containsAll(Set.of("and", "are"));
        assert map.get(6).contains("Kotlin");
        System.out.println("Group by length: " + map);
    }

    public static void binarySearch() {
        List<Integer> numbers = Arrays.asList(42, 8, 23, 16, 15, 4);
        numbers.sort(Integer::compareTo);

        System.out.println("Ordered numbers: " + numbers);

        assert Collections.binarySearch(numbers, 40) < 0;
        assert Collections.binarySearch(numbers, 8) > 0;
        assert Collections.binarySearch(numbers, 42) > 0;
    }

    public static void setOperations() {
        var fruits = Set.of("orange", "apple", "banana");
        var colors = Set.of("orange", "red", "yellow");

        var intersection = new HashSet<>(fruits);
        intersection.retainAll(colors);
        System.out.println("Intersection: " + intersection);

        assert intersection.size() == 1;
        assert intersection.contains("orange");

        var all = new HashSet<>(fruits);
        all.addAll(colors);
        System.out.println("Union: " + all);
        assert all.size() == 5;

        var onlyFruits = new HashSet<>(fruits);
        onlyFruits.removeAll(colors);
        System.out.println("Only fruits: " + onlyFruits);
        assert onlyFruits.size() == 2;
    }
}
