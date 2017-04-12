package logic;

/**
 *
 * @author Kai QI
 * @version 0.2
 * This class is the dice result generator.
 */
public class Dice {

    /**
     * This method is used to generate the dice result for once, only based on the dice.
     * @param face , the number of dice faces.
     * @return int, the result of the dice.
     */
    public static int roll(int face) {
        return roll(1, face, 0);
    }

    /**
     * This method is used to generate the dice result for once, based on the dice and also the dice modifier.
     * @param face , the number of dice faces.
     * @param modifier , the dice modifier which is defined in the D20 rules.
     * @return int, the result of the dice.
     */
    public static int roll(int face, int modifier) {
        return roll(1, face, modifier);
    }

    /**
     * This method is used to generate the dice result for several times.
     * @param times , the number of dice is used.
     * @param face , the number of dice faces.
     * @param modifier , the dice modifier which is defined in the D20 rules.
     * @return int, the final result.
     */
    public static int roll(int times, int face, int modifier) {
        int value = 0;
        for (int i = 0; i < times; i++) {
            value += (int)(Math.random() * face + 1);
        }
        int result = value + modifier;
        Logger.getInstance().log(String.format("Dice.roll %dd%d + %d -> %d", times, face, modifier, result));
        return result;
    }
}
