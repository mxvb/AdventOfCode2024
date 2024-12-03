package org.example.adventofcode2024.day03;

import org.example.adventofcode2024.InputLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    public static void main(String[] args) {
        new Day03().start();
    }

    public static List<String> getInput(List<String> input) {
        String regex = "mul\\(([1-9]\\d{0,2}),([1-9]\\d{0,2})\\)";
        List<String> mulCommands = new ArrayList<>();

        for (String line : input) {

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            // Find all matches and add to the list
            while (matcher.find()) {
                mulCommands.add(matcher.group());
            }
        }
        return mulCommands;
    }

    private void start() {
        List<String> input = InputLoader.getInput("day03.txt");

        partOne(input);
        //partTwo(listOfInts);
    }

    private void partOne(List<String> input) {
        System.out.println(extractedInput(input));

    }

    public int extractedInput(List<String> input) {
        List<String> commands = getInput(input);
        String regex = "mul\\(([1-9]\\d{0,2}),([1-9]\\d{0,2})\\)";
        Pattern pattern = Pattern.compile(regex);
        // List to store extracted values
        List<List<Integer>> extractedValues = new ArrayList<>();

        // Process each command
        for (String command : commands) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.matches()) {
                // Extract x and y and add to the result list
                List<Integer> values = new ArrayList<>();
                values.add(Integer.parseInt(matcher.group(1))); // x
                values.add(Integer.parseInt(matcher.group(2))); // y
                extractedValues.add(values);
            }
        }
        return extractedValues.stream()
                .mapToInt(pair -> pair.getFirst() * pair.get(1))
                .sum();
    }

    private void partTwo() {

    }


}
