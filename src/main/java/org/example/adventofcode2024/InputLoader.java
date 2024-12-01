package org.example.adventofcode2024.day01;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@NoArgsConstructor
public class InputLoader {
    public static List<String> getInput(String fileName) {
        try {
            return Files.readAllLines(Paths.get(ClassLoader.getSystemClassLoader().getResource("day01.txt").toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Something went wrong fetching the input resource.");
        }
    }
}
