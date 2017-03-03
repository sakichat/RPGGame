package ui.controlView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.1
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

        JLabel topicLabel = new JLabel();
        topicLabel.setSize(160, 40);
        topicLabel.setLocation(10, 10);
        add(topicLabel);
        topicLabel.setText("Wall");

        JButton jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 60);
        add(jButton);
        jButton.setText("Remove");
        JButton removeButton = new JButton();
        removeButton = jButton;

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.destroy();
            }
        });

    }

}
