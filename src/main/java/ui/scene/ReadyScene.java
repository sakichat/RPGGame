package ui.scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JButton newGameButton = new JButton("New");
        newGameButton.setSize(160, 40);
        newGameButton.setLocation(20, 60);
        contentView.add(newGameButton);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayScene playScene = new PlayScene();
                ReadyScene.this.navigationView.push(playScene);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadyScene.this.navigationView.pop();
            }
        });

        repaint();
    }
}
