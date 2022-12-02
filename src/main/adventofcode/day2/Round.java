package main.adventofcode.day2;

public class Round {

    private enum Action {
        WIN(6), DRAW(3), LOOSE(0);

        private final int score;

        Action(int score) {
            this.score = score;
        }
    }

    private enum Move {
        ROCK(1), PAPER(2), SCISSOR(3);

        private final int score;

        Move(int score) {
            this.score = score;
        }
    }

    private final Move myMove;
    private final Action action;

    public Round(char opponentMove, char action) {
        this.action = switch (action) {
            case 'X' -> Action.LOOSE;
            case 'Y' -> Action.DRAW;
            case 'Z' -> Action.WIN;
            default -> throw new RuntimeException();
        };
        this.myMove = getMove(opponentMove);
    }

    public int score() {
        return this.action.score + myMove.score;
    }

    private Move getMove(char opponentMove) {
        if (opponentMove == 'A') {
            return switch (this.action) {
                case WIN -> Move.PAPER;
                case LOOSE -> Move.SCISSOR;
                case DRAW -> Move.ROCK;
            };
        }
        if (opponentMove == 'B') {
            return switch (this.action) {
                case WIN -> Move.SCISSOR;
                case LOOSE -> Move.ROCK;
                case DRAW -> Move.PAPER;
            };
        }
        return switch (this.action) {
            case WIN -> Move.ROCK;
            case LOOSE -> Move.PAPER;
            case DRAW -> Move.SCISSOR;
        };
    }

}
