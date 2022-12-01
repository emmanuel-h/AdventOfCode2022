package main.adventofcode;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CaloryCounter caloryCounter = new CaloryCounter();
        System.out.println(caloryCounter.count(1));
        System.out.println(caloryCounter.count(3));
    }
}