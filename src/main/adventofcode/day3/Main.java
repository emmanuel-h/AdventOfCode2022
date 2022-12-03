package main.adventofcode.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        int items = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day3"))) {
            String[] elves = new String[3];
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                elves[counter % 3] = line;
                if (counter % 3 == 2) {
                    items += getItemValue(getCommonItems(elves[0].toCharArray(), elves[1].toCharArray(), elves[2].toCharArray()));
                }
                counter++;
            }
        }

        System.out.println(items);
    }

    // a = 97
    // A=65
    private static int getItemValue(Character item){
        return (int) item >= 97
                ? (int) item - 96
                : (int) item - 64 + 26;
    }

    private static char getCommonItems(char[] c1, char[] c2, char[] c3){
        List<Character> c1List = new String(c1).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> c2List = new String(c2).chars().mapToObj(c -> (char) c).toList();
        List<Character> c3List = new String(c3).chars().mapToObj(c -> (char) c).toList();
        c1List.retainAll(c2List);
        c1List.retainAll(c3List);
        return c1List.get(0);
    }

}