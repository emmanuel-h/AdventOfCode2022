package main.adventofcode.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CaloryCounter {
    public int count(int limit) throws IOException {
        List<Elf> elves = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day1"))) {
            String line;
            Elf elf = new Elf();
            while ((line = reader.readLine()) != null) {
                if ("".equals(line)) {
                    elves.add(elf);
                    elf = new Elf();
                } else {
                    elf.addCalories(Integer.parseInt(line));
                }
            }
        }

        return sumBiggestCalories(limit, elves);
    }

    private int sumBiggestCalories(int limit, List<Elf> elves) {
        return elves.stream()
                .sorted(Comparator.comparing(Elf::getTotalCalories).reversed())
                .limit(limit)
                .mapToInt(Elf::getTotalCalories)
                .sum();
    }
}