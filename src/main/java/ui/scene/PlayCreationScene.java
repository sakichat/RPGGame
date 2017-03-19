package ui.scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayCreationScene extends Scene{
    @Override
    protected void init() {
        super.init();

        title = "Create Play";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    private JLabel label;
    private JButton button;

    public void initSubviews() {
        label = new JLabel("Play", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        JTextField playNameTextField = new JTextField();
        playNameTextField.setSize(160, 40);
        playNameTextField.setLocation(150, 20);
        contentView.add(playNameTextField);

        label = new JLabel("Player", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 80);
        contentView.add(label);

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 80);
        contentView.add(label);
        label.setOpaque(true);
        label.setBackground(new Color(0xf4f4f4));
        JLabel playerNameLabel = label;

        button = new JButton("Select");
        button.setSize(120, 40);
        button.setLocation(320, 80);
        contentView.add(button);
        JButton playerSelectButton = button;

        label = new JLabel("Campaign", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 130);
        contentView.add(label);

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 130);
        contentView.add(label);
        label.setOpaque(true);
        label.setBackground(new Color(0xf4f4f4));
        JLabel campaignNameLabel = label;

        button = new JButton("Select");
        button.setSize(120, 40);
        button.setLocation(320, 130);
        contentView.add(button);
        JButton campaignSelectButton = button;

        button = new JButton("Create");
        button.setSize(120, 40);
        button.setLocation(150, 190);
        contentView.add(button);
        JButton createButton = button;

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayCreationScene.this.navigationView.pop();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadyScene readyScene = new ReadyScene();
                PlayCreationScene.this.navigationView.push(readyScene);
            }
        });
    }
}
