package DnD;

import java.util.Random;

public class Dice {
    static Random rand = new Random();

    private Dice() {
    }

    public static int roll(int count, int dice) throws Exception {
        if (dice == 4 || dice == 6 || dice == 10 || dice == 12 || dice == 20) {
            int sum = 0;

            for (int i = 0; i < count; i++) {
                sum += rand.nextInt(dice + 1);
            }

            return sum;
        } else
            throw new Exception("Не існуючий куб");


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
