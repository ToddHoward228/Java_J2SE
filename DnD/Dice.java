package DnD;

import java.util.Random;

/**
 * The {@code Dice} class simulates dice rolls.
 */
public class Dice {
    static Random rand = new Random();

    private Dice() {
    }

    /**
     * Roll dice
     * @param count count of dice
     * @param die specified die D6, D20
     * @return Return sum of dies roll results
     */
    public static int roll(int count, DX die) {
        if (die == null)
            throw new NullPointerException("die cannot be null");

        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += rand.nextInt(die.getNumValue()) + 1;
        }

        return sum;
    }

    /**
     * Roll a die
     * @param die specified die D6, D20
     * @return Return result of die roll
     */
    public static int roll(DX die) {
        if (die == null)
            throw new NullPointerException("die cannot be null");

        return rand.nextInt(die.getNumValue()) + 1;
    }

    /**
     * Roll stat of character. 4 D6 subtract the worst result
     * @return stat of character. 3 - 18.
     */
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
