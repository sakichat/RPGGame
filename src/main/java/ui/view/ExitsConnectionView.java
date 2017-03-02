package ui.view;

import javax.swing.*;

/**
 * Created by Penelope on 17/2/28.
 */
public class ExitsConnectionView extends View{
    public ExitsConnectionView() {
        this.setSize(380, 40);

        initSubviews();
    }

    private JLabel label;
    private JTextField textField;

    private void initSubviews() {

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(40, 40);
        label.setLocation(0, 0);
        add(label);
        JLabel idLabel = label;

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(50, 0);
        add(label);
        JLabel mapNameLabel = label;

        textField = new JTextField();
        textField.setSize(160, 40);
        textField.setLocation(220, 0);
        add(textField);
        JTextField exitsConnection = textField;

    }
}
