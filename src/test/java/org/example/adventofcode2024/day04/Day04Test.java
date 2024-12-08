package org.example.adventofcode2024.day04;

import org.example.adventofcode2024.InputLoader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day04Test {
    private final Day04 day04 = new Day04();

    @Test
    void findXmas_testSet() {
        List<String> inputLines = InputLoader.getInput("day04_testset.txt");

        int xmas = day04.findXmasInGrid(inputLines);
        assertThat(xmas).isEqualTo(18);
    }
    @Test
    void findXmas() {
        List<String> inputLines = InputLoader.getInput("day04.txt");

        int xmas = day04.findXmasInGrid(inputLines);
        assertThat(xmas).isEqualTo(2462);
    }





}