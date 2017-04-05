package ui.controlView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.2
 *
 * This class is for ObstableControlview.
 */
public class ObstacleControlView extends ControlView {

    /**
     * constructor of the View.
     */
    public ObstacleControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    /**
     * layout
     */
    public void initSubviews() {

        JLabel topicLabel = new JLabel("Wall");
        topicLabel.setSize(160, 40);
        topicLabel.setLocation(10, 10);
        add(topicLabel);

        JButton button;

        button = new JButton("Remove");
        button.setSize(160, 40);
        button.setLocation(10, 60);
        add(button);
        JButton removeButton = button;

        removeButton.addActionListener(e -> mapEditingScene.destroy());

    }

}
