package org.example.adventofcode2024.day04;

import org.example.adventofcode2024.InputLoader;

import java.util.List;

public class Day04 {

    public static final String XMAS = "XMAS";
    public static final String SAMX = "SAMX";

    public static void main(String[] args) {
        new Day04().start();
    }

    private void start() {
        List<String> lines = InputLoader.getInput("day04_testset.txt");
        partOne(lines);
        partTwo(lines);
    }

    private void partOne(List<String> input) {
        System.out.println(findXmasHorizontalForward(input));
    }

    private void partTwo(List<String> input) {

    }

    public int findXmasHorizontalForward(List<String> input) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size() - 4; j++) {
                if (input.get(i).charAt(j) == 'X' &&
                        input.get(i).charAt(j + 1) == 'M' &&
                        input.get(i).charAt(j + +2) == 'A' &&
                        input.get(i).charAt(j + +3) == 'S'
                ) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findXmasHorizontalBackWard(List<String> input) {
        int count = 0;
        for (int i = input.size() - 1; i >= 0; i--) {
            for (int j = input.size() - 4; j >= 0; j--) {
                if (input.get(i).charAt(j) == 'S' &&
                        input.get(i).charAt(j + 1) == 'A' &&
                        input.get(i).charAt(j + +2) == 'M' &&
                        input.get(i).charAt(j + +3) == 'X'
                ) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findXmasVerticalForward(List<String> input) {
        int count = 0;
        for (int i = 0; i < input.size() - 4; i++) {
            for (int j = 0; j < input.size(); j++) {
                if (input.get(j).charAt(i) == 'X' &&
                        input.get(i + 1).charAt(j) == 'M' &&
                        input.get(i + 2).charAt(j) == 'A' &&
                        input.get(i + 3).charAt(j) == 'S'
                ) {
                    count++;
                }
            }
        }
        return count;
    }
    public int findXmasVerticalBackward(List<String> input) {
        int count = 0;
        for (int i = input.size() - 1; i >= 0; i--) {
            for (int j = input.size() - 4; j >= 0; j--) {
                if (input.get(i).charAt(j) == 'S' &&
                        input.get(i).charAt(j + 1) == 'A' &&
                        input.get(i).charAt(j + +2) == 'M' &&
                        input.get(i).charAt(j + +3) == 'X'
                ) {
                    count++;
                }
            }
        }
        return count;
    }





}
