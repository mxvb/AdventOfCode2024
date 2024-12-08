package org.example.adventofcode2024.day04;

import org.example.adventofcode2024.InputLoader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day04Test {
    private final Day04 day04 = new Day04();
    private final List<String> inputLines = InputLoader.getInput("day04_testset.txt");

    @Test
    void findXmasHorizontalForward() {
        for(String line : inputLines) {
            System.out.println(line);
        }
        int xmasHorizontal = day04.findXmasHorizontalForward(inputLines);
        assertThat(xmasHorizontal).isEqualTo(3);
    }

    @Test
    void findXmasHorizontalBackward() {
        for (String line : inputLines) {
            System.out.println(line);
        }
        int xmasHorizontal = day04.findXmasHorizontalBackWard(inputLines);
        assertThat(xmasHorizontal).isEqualTo(2);
    }
    @Test
    void findXmasVerticalForward() {
        for (String line : inputLines) {
            System.out.println(line);
        }
        int xmasHorizontal = day04.findXmasVerticalForward(inputLines);
        assertThat(xmasHorizontal).isEqualTo(1);
    }

    @Test
    void findXmasVerticalBackward() {
        for (String line : inputLines) {
            System.out.println(line);
        }
        int xmasHorizontal = day04.findXmasVerticalBackward(inputLines);
        assertThat(xmasHorizontal).isEqualTo(2);
    }





}