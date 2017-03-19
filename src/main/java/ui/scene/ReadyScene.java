package ui.scene;

import logic.Campaign;

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

        JLabel label = new JLabel("Play");
        label.setSize(160, 40);
        label.setLocation(20, 20);
        contentView.add(label);
        JLabel playNameLabel = label;

        JButton button = new JButton("New");
        button.setSize(160, 40);
        button.setLocation(20, 70);
        contentView.add(button);
        JButton newGameButton = button;

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
