package ui.view;

/**
 * This class is used by dataToView, to get value
 * @author Qi Xia
 * @version 0.2
 */
public class TextDisplay {
    public static String signedNumber(int value){
        return value < 0 ? "" + value : "+" + value;
    }
}
