package main.adventofcode.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day6"))) {
            int[] input= reader.readLine()
                    .chars()
                    .toArray();

            for (int i = 0; i<input.length - 14; i++) {
                long count = Arrays.stream(Arrays.copyOfRange(input, i, i + 14))
                        .boxed()
                        .collect(Collectors.toSet())
                        .size();
                if (count == 14) {
                    System.out.println(i + 14);
                    break;
                }
            }
        }
    }
}
