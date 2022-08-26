package org.example;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        printAllNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
        System.out.println("========================");
        System.out.println("========================");
        printEventNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
        System.out.println("========================");
        System.out.println("========================");
        printSquaresOfEventNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));

    }

    private static void print(int number) {
        System.out.println(number);
    }

//    private static boolean isEvent(int number) {
//        return number % 2 == 0;
//    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {

        // what to do?
        numbers.stream()
                // method reference
                .forEach(FP01Functional::print);
    }

    private static void printEventNumbersInListFunctional(List<Integer> numbers) {

        // what to do?
        numbers.stream()
                // filter - only allow event number
//                .filter(FP01Functional::isEvent)
                // lambda expressions
                .filter(number -> (number % 2) == 0)
                // method reference
                .forEach(FP01Functional::print);
    }

    private static void printSquaresOfEventNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream()
                .filter(number -> (number % 2) == 0)
                // Mapping - x -> x * x
                .map(number -> number * number)
                .forEach(FP01Functional::print);

    }

}
