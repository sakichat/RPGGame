package ui.scene;

import javax.swing.*;

/**
 * This class is the last scene in whole game, and it can back to MainScene with ending the campaign.
 * @author Siyu Chen
 * @version 0.3
 */
public class FinishScene extends Scene {

    private JLabel messageLabel;

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
     * These parameters are for message.
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        messageLabel.setText(message);
    }

    /**
     * This method creates components on the main scene
     */
    protected void initSubviews() {
        messageLabel = new JLabel(message, JLabel.CENTER);
        messageLabel.setSize(160, 40);
        messageLabel.setLocation(20, 20);
        contentView.add(messageLabel);

        JButton button = new JButton("Back");
        button.setSize(160, 40);
        button.setLocation(20, 80);
        contentView.add(button);

        button.addActionListener(e -> FinishScene.this.navigationView.popTo(MainScene.class));
    }
}
