package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class MapCreationScene extends Scene {

    @Override
    protected void init() {
        super.init();

        title = "Create Map";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    protected void initSubviews() {

        JLabel label;
        JButton button;

        label = new JLabel("Name", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        JTextField nameField = new JTextField();
        nameField.setSize(160, 40);
        nameField.setLocation(150, 20);
        contentView.add(nameField);

        label = new JLabel("Size", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 70);
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setLocation(150, 70);
        label.setText("4 x 4");
        contentView.add(label);
        JLabel sizeLabel = label;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 120);
        contentView.add(button);
        button.setText("4 x 4");
        JButton smallSize = button;

        smallSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeLabel.setText(smallSize.getText());
                repaint();
            }
        });

        button = new JButton("8 x 8");
        button.setSize(100, 40);
        button.setLocation(260, 120);
        contentView.add(button);
        JButton mediumSize = button;

        mediumSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeLabel.setText(mediumSize.getText());
                repaint();
            }
        });


        button = new JButton("12 x 12");
        button.setSize(100, 40);
        button.setLocation(370, 120);
        contentView.add(button);
        JButton largeSize = button;

        largeSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeLabel.setText(largeSize.getText());
            }
        });

        JButton create = new JButton("Create");
        create.setSize(160, 40);
        create.setLocation(150, 190);
        contentView.add(create);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapCreationScene.this.navigationView.pop();
            }
        });
    }
}
