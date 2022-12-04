package main.adventofcode.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        long sectionNumbers = Files.lines(Paths.get("src/main/resources/day4"))
                .map(l -> l.split("[-,]"))
                .filter(a -> (Integer.parseInt(a[0]) <= Integer.parseInt(a[2]) && Integer.parseInt(a[1]) >= Integer.parseInt(a[2]))
                || (Integer.parseInt(a[2]) <= Integer.parseInt(a[1]) && Integer.parseInt(a[3]) >= Integer.parseInt(a[0])))
                .count();
        System.out.println(sectionNumbers);
    }
}
