package ui.scene;

import logic.Play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This ReadyScene means players have already created a play within player and campaign.
 * @author Siyu Chen
 * @version 0.2
 */
public class ReadyScene extends Scene {

//    private Play play;
//
//    /**
//     * Getter for play.
//     * @return
//     */
//    public Play getPlay() {
//        return play;
//    }
//
//    /**
//     * Setter for play.
//     * @param play
//     */
//    public void setPlay(Play play) {
//        this.play = play;
//        dataToView();
//    }

    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        title = "Ready";
        backButtonEnabled = true;
        saveButtonEnabled = false;

    }

    JLabel playNameLabel;

    /**
     * This method creates components on this scene
     * And adds events on buttons
     */
    protected void initSubviews() {

        JLabel label = new JLabel("Play");
        label.setSize(160, 40);
        label.setLocation(20, 20);
        contentView.add(label);
        playNameLabel = label;

        JButton button = new JButton("New");
        button.setSize(160, 40);
        button.setLocation(20, 70);
        contentView.add(button);
        JButton newGameButton = button;

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayCreationScene playCreationScene = new PlayCreationScene();
//                playScene.setPlay(play);
                ReadyScene.this.navigationView.push(playCreationScene);
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

//    public void dataToView() {
//        playNameLabel.setText(play.getName());
//    }
}
