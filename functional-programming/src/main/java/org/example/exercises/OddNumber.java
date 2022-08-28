package org.example.exercises;

import java.util.List;

public class OddNumber {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printOddNumberInListFunctional(numbers);
        System.out.println("++++++++++++++++++");
        printCubeOfOddNumberInListFunctional(numbers);

        System.out.println();

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .forEach(System.out::println);

        System.out.println();

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        System.out.println();

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

        System.out.println();

        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);

    }

    private static void printOddNumberInListFunctional(List<Integer> numbers) {

        // Convert to stream
        numbers.stream()
                .filter(number -> (number % 2) == 1)
                .forEach(System.out::println);

    }

    private static void printCubeOfOddNumberInListFunctional(List<Integer> numbers) {

        // Convert to stream
        numbers.stream()
                .filter(number -> (number % 2) == 1)
                .map(number -> number * number *number)
                .forEach(System.out::println);

    }

}
