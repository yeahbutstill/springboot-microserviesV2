package org.example;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayWithOptional {

    public static void main(String[] args) {

        List<String> fruits = List.of("Apple", "Banana", "Mango");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
        Predicate<? super String> predicate1 = fruit -> fruit.startsWith("B");
        Optional<String> first = fruits.stream().filter(predicate).findFirst();
        Optional<String> first1 = fruits.stream().filter(predicate1).findFirst();
        System.out.println("You are not a real Java Programmer until you've deal with a null pointer exception");
        System.out.println("Exception we hate the most: 'java.lang.NullPointerException'");
        System.out.println("so BIG THANKS for Tony Hoare for this ALGOL");
        System.out.println("=============================");
        System.out.println(first.isEmpty());
        System.out.println(first);
        System.out.println(first.isPresent());
        System.out.println("============================");
        System.out.println(first1.isEmpty());
        System.out.println(first1);
        System.out.println(first1.isPresent());
        System.out.println(first1.get());
        System.out.println("============================");
        Optional<String> banana = Optional.of("Banana");
        Optional<String> empty = Optional.empty();
        System.out.println(banana);
        System.out.println(empty);

    }

}
