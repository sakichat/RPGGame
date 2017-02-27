package ui.view;

/**
 * @author Qi Xia
 * @version 0.1
 */
public class TextDisplay {
    public static String signedNumber(int value){
        return value < 0 ? "" + value : "+" + value;
    }
}
