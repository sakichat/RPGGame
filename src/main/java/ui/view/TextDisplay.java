package ui.view;

/**
 * @author Qi Xia
 */
public class TextDisplay {
    public static String signedNumber(int value){
        return value < 0 ? "" + value : "+" + value;
    }
}
