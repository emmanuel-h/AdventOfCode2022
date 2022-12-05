package main.adventofcode.day5.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day5"))) {
            Map<Integer, Deque<Character>> stacks = Map.of(1, new ArrayDeque<>(), 2, new ArrayDeque<>(), 3, new ArrayDeque<>(), 4, new ArrayDeque<>(), 5, new ArrayDeque<>(), 6, new ArrayDeque<>(), 7, new ArrayDeque<>(), 8, new ArrayDeque<>(), 9, new ArrayDeque<>());
            String line = reader.readLine();
            while (!line.startsWith(" 1")) {
                for (int i = 1; i < 10; i++) {
                    if (line.charAt(1) != ' ') {
                        stacks.get(i).addLast(line.charAt(1));
                    }
                    line = i == 9 ? line.substring(3)
                            : line.substring(4);
                }
                line = reader.readLine();
            }

            reader.readLine(); // Empty line 10

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(" ", "");
                line = line.replaceAll("move", "");
                line = line.replaceAll("from", ",");
                line = line.replaceAll("to", ",");
                String[] s = line.split(",");
                int move = Integer.parseInt(s[0]);
                int from = Integer.parseInt(s[1]);
                int to = Integer.parseInt(s[2]);

                Deque<Character> temporaryDeque = new ArrayDeque<>();
                while (move > 0) {
                    temporaryDeque.addLast(stacks.get(from).pollFirst());
                    move--;
                }
                while (!temporaryDeque.isEmpty()) stacks.get(to).addFirst(temporaryDeque.pollLast());
            }

            System.out.print(stacks.get(1).getFirst());
            System.out.print(stacks.get(2).getFirst());
            System.out.print(stacks.get(3).getFirst());
            System.out.print(stacks.get(4).getFirst());
            System.out.print(stacks.get(5).getFirst());
            System.out.print(stacks.get(6).getFirst());
            System.out.print(stacks.get(7).getFirst());
            System.out.print(stacks.get(8).getFirst());
            System.out.print(stacks.get(9).getFirst());
        }
    }
}
