package game;

/**
 *
 * @author Kai QI
 * @version V 1.0
 *
 */
public class Dice {

    /**
     * This method is used to generate the dice result for once, only based on the dice.
     * @param face , the number of dice faces.
     * @return int, the result of the dice.
     */
    public static int rool(int face) {
        return (int)(Math.random() * face + 1);
    }

    /**
     * This method is used to generate the dice result for once, based on the dice and also the dice modifier.
     * @param face , the number of dice faces.
     * @param modifier , the dice modifier which is defined in the D20 rules.
     * @return int, the result of the dice.
     */
    public static int rool(int face, int modifier) {
        return rool(face) + modifier;
    }

    /**
     * This method is used to generate the dice result for several times.
     * @param times , the number of dice is used.
     * @param face , the number of dice faces.
     * @param modifier , the dice modifier which is defined in the D20 rules.
     * @return int, the final result.
     */
    public static int rool(int times, int face, int modifier) {
        return times * rool(face) + modifier;
    }
}
