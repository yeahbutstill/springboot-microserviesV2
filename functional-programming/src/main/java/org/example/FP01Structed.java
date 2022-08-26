package org.example;

import java.util.List;

public class FP01Structed {

    public static void main(String[] args) {
        printAllNumbersInListStructed(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
        System.out.println("=============");
        System.out.println("+++++++++++++");
        printEventNumbersInListStructed(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static void printAllNumbersInListStructed(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static void printEventNumbersInListStructed(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }


}