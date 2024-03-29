package ui.controlView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.3
 * This class is for exitControlView.
 */
public class ExitControlView extends ControlView {


    /**
     * constructor of the View.
     */
    public ExitControlView() {
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
        topicLabel.setText("Exit");

        JButton jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 60);
        add(jButton);
        jButton.setText("Remove");
        JButton removeButton = new JButton();
        removeButton = jButton;

        removeButton.addActionListener(e -> mapEditingScene.destroy());
    }
}
