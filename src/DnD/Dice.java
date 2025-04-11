package DnD;

import java.util.Random;

public class Dice {
    static Random rand = new Random();

    private Dice() {
    }

    public static int roll(int count, DiceVar dice) {
        if (dice == null)
            throw new NullPointerException("dice cannot be null");

        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += rand.nextInt(dice.getNumValue()) + 1;
        }

        return sum;
    }

    public static int roll(DiceVar dice) {
        if (dice == null)
            throw new NullPointerException("dice cannot be null");

        return rand.nextInt(dice.getNumValue()) + 1;
    }

    public static int rollStat() {
        int sum = 0;
        int min = 6;

        for (int i = 0; i < 4; i++) {
            int roll = rand.nextInt(7);
            if (roll < min)
                min = roll;
            sum += roll;

        }
        return sum - min;
    }
}
