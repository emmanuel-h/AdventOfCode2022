package main.adventofcode;

public class Elf {
    private int totalCalories;

    public Elf() {
        this.totalCalories = 0;
    }

    public void addCalories(int calories){
        this.totalCalories += calories;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
