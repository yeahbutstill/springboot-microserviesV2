package org.example;

import java.util.List;

public class FP01Structed {

    public static void main(String[] args) {
        printAllNumbersInListStructed(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static void printAllNumbersInListStructed(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }


}
