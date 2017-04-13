package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the last scene in whole game, and it can back to MainScene with ending the campaign.
 * @author Siyu Chen
 * @version 0.3
 */
public class FinishScene extends Scene {
    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        title = "Finish Game";
        backButtonEnabled = false;
        saveButtonEnabled = false;
    }

    /**
     * These parameters are for messageLabel.
     */
    private String messageLabel;

    public String getMessageLabel() {
        return messageLabel;
    }

    public void setMessageLabel(String messageLabel) {
        this.messageLabel = messageLabel;
    }

    /**
     * This method creates components on the main scene
     */
    protected void initSubviews() {
        JLabel label = new JLabel(messageLabel, JLabel.CENTER);
        label.setSize(160, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        JButton button = new JButton("Back");
        button.setSize(160, 40);
        button.setLocation(20, 80);
        contentView.add(button);

        button.addActionListener(e -> FinishScene.this.navigationView.popTo(MainScene.class));
    }
}
