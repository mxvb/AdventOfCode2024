package org.example.adventofcode2024.day02;

import org.example.adventofcode2024.InputLoader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day02Test {

    private final Day02 day02 = new Day02();

    @Test
    void partOneTest() {
        String safeInputString = "7 6 4 2 1";
        String[] parts = safeInputString.split(" ");
        List<Integer> numbers = Arrays.stream(parts)
                .map(Integer::parseInt)
                .toList();
        System.out.println(numbers);
    }

    @Test
    void partOneTest2() {
        List<String> input = InputLoader.getInput("day02.txt");
        List<List<Integer>> listOfInts = input.stream()
                .map(str ->Arrays.stream(str.split(" "))
                        .map(Integer::parseInt)
                        .toList()).toList();

        int count = 0;
        for (List<Integer> innerList : listOfInts) {
            if (day02.isSafe(innerList)) {
                count++;
            }
        }
        System.out.println("count = " + count);
    }

    @Test
    void testIfListSafe() {
        List<Integer> input = List.of(7, 6, 4, 2, 1);
        assertThat(day02.isListDiffLessThan3(input)).isTrue();
    }

    @Test
    void testIfListNotSafe() {
        List<Integer> input = List.of(1, 2, 7, 8, 9);
        assertThat(day02.isListDiffLessThan3(input)).isFalse();
    }

    @Test
    void testAscendingList() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        assertThat(day02.isAscending(input)).isTrue();
    }

    @Test
    void testNotAscendingList() {
        List<Integer> input = List.of(1, 2, 8, 4, 5);
        assertThat(day02.isAscending(input)).isFalse();
    }

    @Test
    void testDescendingList() {
        List<Integer> input = List.of(5, 4, 3, 2, 1);
        assertThat(day02.isDescending(input)).isTrue();
    }

    @Test
    void testNotDescendingList() {
        List<Integer> input = List.of(5, 4, 8, 2, 1);
        assertThat(day02.isDescending(input)).isFalse();
    }

    @Test
    void testIsSafe() {
        List<Integer> list1 = List.of(7, 6, 4, 2, 1);
        List<Integer> list2 = List.of(1, 2, 7, 8, 9);
        List<Integer> list3 = List.of(9, 7, 6, 2, 1);
        List<Integer> list4 = List.of(1, 3, 2, 4, 5);
        List<Integer> list5 = List.of(8, 6, 4, 4, 1);
        List<Integer> list6 = List.of(1, 3, 6, 7, 9);

        assertThat(day02.isSafe(list1)).isTrue();
        assertThat(day02.isSafe(list2)).isFalse();
        assertThat(day02.isSafe(list3)).isFalse();
        assertThat(day02.isSafe(list4)).isFalse();
        assertThat(day02.isSafe(list5)).isFalse();
        assertThat(day02.isSafe(list6)).isTrue();
    }
    @Test
    void testIsSafeWithExtraSteps() {
        List<Integer> list1 = List.of(7, 6, 4, 2, 1);
        List<Integer> list2 = List.of(1, 2, 7, 8, 9);
        List<Integer> list3 = List.of(9, 7, 6, 2, 1);
        List<Integer> list4 = List.of(1, 3, 2, 4, 5);
        List<Integer> list5 = List.of(8, 6, 4, 4, 1);
        List<Integer> list6 = List.of(1, 3, 6, 7, 9);

        assertThat(day02.isSafeByRemovingOneNumber(list1)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumber(list2)).isFalse();
        assertThat(day02.isSafeByRemovingOneNumber(list3)).isFalse();
        assertThat(day02.isSafeByRemovingOneNumber(list4)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumber(list5)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumber(list6)).isTrue();
    }
    @Test
    void testIsSafeWithExtraSteps2() {
        List<Integer> list1 = List.of(7, 6, 4, 2, 1);
        List<Integer> list2 = List.of(1, 2, 7, 8, 9);
        List<Integer> list3 = List.of(9, 7, 6, 2, 1);
        List<Integer> list4 = List.of(1, 3, 2, 4, 5);
        List<Integer> list5 = List.of(8, 6, 4, 4, 1);
        List<Integer> list6 = List.of(1, 3, 6, 7, 9);

        assertThat(day02.isSafeByRemovingOneNumberOptimized(list1)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumberOptimized(list2)).isFalse();
        assertThat(day02.isSafeByRemovingOneNumberOptimized(list3)).isFalse();
        assertThat(day02.isSafeByRemovingOneNumberOptimized(list4)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumberOptimized(list5)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumberOptimized(list6)).isTrue();
    }

    @Test
    void testIsSafeWithExtraSteps3() {
        List<Integer> list1 = List.of(7, 6, 4, 2, 1);
        List<Integer> list2 = List.of(1, 2, 7, 8, 9);
        List<Integer> list3 = List.of(9, 7, 6, 2, 1);
        List<Integer> list4 = List.of(1, 3, 2, 4, 5);
        List<Integer> list5 = List.of(8, 6, 4, 4, 1);
        List<Integer> list6 = List.of(1, 3, 6, 7, 9);

        assertThat(day02.isSafeByRemovingOneNumberWithStream(list1)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumberWithStream(list2)).isFalse();
        assertThat(day02.isSafeByRemovingOneNumberWithStream(list3)).isFalse();
        assertThat(day02.isSafeByRemovingOneNumberWithStream(list4)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumberWithStream(list5)).isTrue();
        assertThat(day02.isSafeByRemovingOneNumberWithStream(list6)).isTrue();
    }
}