package main.adventofcode.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        int score = Files.lines(Paths.get("src/main/resources/day2"))
                .map(line -> new Round(line.charAt(0), line.charAt(2)))
                .mapToInt(Round::score)
                .sum();
        System.out.println(score);
    }

}