package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Siyu Chen
 * @version 0.1
 */
public class PlayerCreationScene extends Scene {
    @Override
    protected void init() {
        super.init();

        title = "Create Player";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    protected void initSubviews() {
        JLabel nameLabel = new JLabel("Name", JLabel.RIGHT);
        nameLabel.setSize(120, 40);
        nameLabel.setLocation(20, 20);
        contentView.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(160,40);
        nameField.setLocation(150, 20);
        contentView.add(nameField);

        JButton createButton = new JButton("Create");
        createButton.setSize(160, 40);
        createButton.setLocation(150, 90);
        contentView.add(createButton);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerCreationScene.this.navigationView.pop();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerEditingScene playerEditingScene = new PlayerEditingScene();
                PlayerCreationScene.this.navigationView.push(playerEditingScene);
            }
        });
    }
}
