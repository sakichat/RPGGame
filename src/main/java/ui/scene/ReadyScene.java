package ui.scene;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.2
 */
public class ReadyScene extends Scene {
    @Override
    protected void init() {
        super.init();

        title = "Ready";
        backButtonEnabled = true;
        saveButtonEnabled = false;

    }

    protected void initSubviews() {
        TextField textField = new TextField("Play");
        textField.setSize(160, 40);
        textField.setLocation(20, 20);
        contentView.add(textField);

        JButton editorButton = new JButton("New");
        editorButton.setSize(160, 40);
        editorButton.setLocation(20, 60);
        contentView.add(editorButton);

        repaint();
    }
}
