package org.example.adventofcode2024.day02;

import org.example.adventofcode2024.InputLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day02 {

    public static void main(String[] args) {
        new Day02().start();
    }

    private void start() {
        List<String> input = InputLoader.getInput("day02.txt");

        List<List<Integer>> listOfInts = input.stream()
                .map(str -> Arrays.stream(str.split(" "))
                        .map(Integer::parseInt)
                        .toList()).toList();
        partOne(listOfInts);
        partTwo(listOfInts);
    }

    private void partOne(List<List<Integer>> input) {
        int count = 0;
        for (List<Integer> innerList : input) {
            if (isSafe(innerList)) {
                count++;
            }
        }
        System.out.println("partOne = " + count);

    }

    private void partTwo(List<List<Integer>> input) {
        int count = 0;
        for (List<Integer> innerList : input) {
            if (isSafeByRemovingOneNumberOptimized(innerList)) {
                count++;
            }
        }
        System.out.println("partTwo = " + count);
    }

    private boolean isDifference3OrLess(int num1, int num2) {
        return Math.abs(num1 - num2) <= 3;
    }

    public boolean isListDiffLessThan3(List<Integer> input) {
        for (int i = 1; i < input.size(); i++) {
            if (!isDifference3OrLess(input.get(i-1), input.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isAscending(List<Integer> input) {
        return IntStream.range(0, input.size() - 1)
                .allMatch(i -> input.get(i) < input.get(i + 1));
    }

    public boolean isDescending(List<Integer> input) {
        return IntStream.range(0, input.size() - 1)
                .allMatch(i -> input.get(i) > input.get(i + 1));
    }

    public Boolean isSafe(List<Integer> input) {
        return (isAscending(input) || isDescending(input)) && isListDiffLessThan3(input);
    }

    public Boolean isSafeByRemovingOneNumber(List<Integer> input) {
        List<Integer> temp = new ArrayList<>(input);
        for (int i = 0; i < input.size(); i++) {
            int tempNumber = input.get(i);
            temp.remove(i);
            if (isSafe(temp)) {
                return true;
            } else {
                temp.add(i, tempNumber);
            }
        }
        return false;
    }

    public Boolean isSafeByRemovingOneNumberOptimized(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            List<Integer> temp = new ArrayList<>(input);
            temp.remove(i);
            if (isSafe(temp)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isSafeByRemovingOneNumberWithStream(List<Integer> input) {
        return IntStream.range(0, input.size())
                .anyMatch(i -> {
                    List<Integer> temp = new ArrayList<>(input);
                    temp.remove(i);
                    return isSafe(temp);
                });
    }
}
