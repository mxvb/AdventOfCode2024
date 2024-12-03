package org.example.adventofcode2024.day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class Day03Test {

    private final Day03 day03 = new Day03();
    @Test
    void testAlgoToGetInput() {
        List<String> input = List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        List<String> output = List.of("mul(2,4)","mul(5,5)","mul(11,8)","mul(8,5)");

        assertThat(output).isEqualTo(Day03.getInput(input));
    }

    @Test
    void testAlgo() {
        List<String> input = List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        int output = day03.extractedInput(input);
        assertThat(output).isEqualTo(161);
    }
}