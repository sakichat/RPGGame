package ui.controlView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.3
 * This class is for entranceControlView.
 */
public class EntranceControlView extends ControlView {

    /**
     * constructor of the View.
     */
    public EntranceControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    /**
     * layout
     */
    public void initSubviews() {

        JLabel label = new JLabel("Entrance");
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);

        JButton button = new JButton("Remove");
        button.setSize(160, 40);
        button.setLocation(10, 60);
        add(button);
        JButton removeButton = button;

        removeButton.addActionListener(e -> mapEditingScene.destroy());

    }
}
