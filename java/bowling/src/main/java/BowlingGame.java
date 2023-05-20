public class BowlingGame {
    public static void main(String[] args) {

    }

    private int[] rolls;
    private int dices = 0;

    public void setRolls(int[] rolls) {
        this.rolls = rolls;
    }

    public void roll(int pins) throws IllegalStateException {
        if (pins < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        } else if (pins > 10) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        } else {
            rolls[dices] = pins;
            dices++;
        }
    }


    public int score() throws IllegalStateException {
        int score = 0;

        for (int i = 0; i < rolls.length - 1; i += 2) {
            int step = rolls[i] + rolls[i + 1];

            if (step > 10) {
                throw new IllegalStateException("Pin count exceeds pins on the lane");
            } else if (step == 10) {
                score += step + rolls[i + 2];
            }
        }

        return score;
    }
}
