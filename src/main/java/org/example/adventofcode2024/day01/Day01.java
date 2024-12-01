package org.example.adventofcode2024.day01;

import org.example.adventofcode2024.InputLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Day01 {

    public static void main(String[] args) {
        new Day01().start();
    }

    private void start() {
        List<String> input = InputLoader.getInput("day01.txt");
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();

        for (String line : input) {
            String[] split = line.split(" {3}");
            listOne.add(Integer.parseInt(split[0]));
            listTwo.add(Integer.parseInt(split[1]));
        }
        partOne(listOne, listTwo);
        partTwo(listOne, listTwo);
    }

    private void partOne(List<Integer> listOne, List<Integer> listTwo) {
        System.out.println(calculateDistance(listOne, listTwo));
    }

    private void partTwo(List<Integer> listOne, List<Integer> listTwo) {
        System.out.println(calculateSimilarityScore(listOne, listTwo));
    }

    private int calculateDistance(List<Integer> listOne, List<Integer> listTwo) {
        Collections.sort(listOne);
        Collections.sort(listTwo);

        return IntStream.range(0, listOne.size())
                .map(i -> Math.abs(listOne.get(i) - listTwo.get(i)))
                .sum();
    }

    private int calculateSimilarityScore(List<Integer> listOne, List<Integer> listTwo) {
        int similarityScore = 0;

        for (Integer i : listOne) {
            int frequency = Collections.frequency(listTwo, i);
            similarityScore += frequency * i;
        }
        return similarityScore;
    }

}
