package org.example.adventofcode2024.day04;

import org.example.adventofcode2024.InputLoader;

import java.util.List;

public class Day04 {

    public static final String XMAS = "XMAS";

    public static void main(String[] args) {
        new Day04().start();
    }

    private void start() {
        List<String> lines = InputLoader.getInput("day04.txt");
        partOne(lines);
        partTwo(lines);
    }

    private void partOne(List<String> input) {
        System.out.println(findXmasInGrid(input));
    }

    private void partTwo(List<String> input) {

    }

    public int findXmasInGrid(List<String> input) {
        int count = 0;

        // Define all 8 directions as (rowStep, colStep)
        int[][] directions = {
                {0, 1},    // Horizontal forward
                {0, -1},   // Horizontal backward
                {1, 0},    // Vertical forward
                {-1, 0},   // Vertical backward
                {1, 1},    // Diagonal forward (top-left to bottom-right)
                {-1, -1},  // Diagonal backward (bottom-right to top-left)
                {1, -1},   // Reverse diagonal forward (top-right to bottom-left)
                {-1, 1}    // Reverse diagonal backward (bottom-left to top-right)
        };

        // Count occurrences in all directions
        for (int[] direction : directions) {
            count += findInDirection(input, direction[0], direction[1]);
        }

        return count;
    }

    private int findInDirection(List<String> grid, int rowStep, int colStep) {
        int rows = grid.size();
        int cols = grid.getFirst().length();
        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (canFindWord(grid, row, col, rowStep, colStep)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean canFindWord(List<String> grid, int startRow, int startCol, int rowStep, int colStep) {
        int rows = grid.size();
        int cols = grid.getFirst().length();
        int wordLength = XMAS.length();

        for (int i = 0; i < wordLength; i++) {
            int row = startRow + i * rowStep;
            int col = startCol + i * colStep;

            // Check boundaries and character match
            if (row < 0 || row >= rows || col < 0 || col >= cols || grid.get(row).charAt(col) != XMAS.charAt(i)) {
                return false;
            }
        }

        return true;
    }






}
