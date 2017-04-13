package ui.scene;

import logic.Play;
import ui.panel.PlaySelectorPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This ReadyScene means players have already created a play within currentPlayer and campaign.
 * @author Siyu Chen
 * @version 0.3
 */
public class ReadyScene extends Scene implements PlaySelectorPanel.Delegate{

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

    JLabel label;
    JButton button;

    /**
     * This method creates components on this scene
     * And adds events on buttons
     */
    protected void initSubviews() {

        label = new JLabel("Play");
        label.setSize(160, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        button = new JButton("New");
        button.setSize(160, 40);
        button.setLocation(20, 70);
        contentView.add(button);
        JButton newGameButton = button;

        button = new JButton("Load");
        button.setSize(160, 40);
        button.setLocation(20, 130);
        contentView.add(button);
        JButton loadGameButton = button;

        backButton.addActionListener(e -> ReadyScene.this.navigationView.pop());

        newGameButton.addActionListener(e -> {
            PlayCreationScene playCreationScene = new PlayCreationScene();
            ReadyScene.this.navigationView.push(playCreationScene);

        });

        loadGameButton.addActionListener(e -> {
            PlaySelectorPanel playSelectorPanel = new PlaySelectorPanel();
            playSelectorPanel.setLocation(20, 190);
            playSelectorPanel.setDelegate(ReadyScene.this);
            contentView.add(playSelectorPanel);
        });

        repaint();
    }

    /**
     * The method of playSelectorPerformAction
     * @param playSelectorPanel PlaySelectorPanel
     * @param play Play
     */
    @Override
    public void playSelectorPerformAction(PlaySelectorPanel playSelectorPanel, Play play) {

        contentView.remove(playSelectorPanel);

        PlayScene playScene = new PlayScene();
        playScene.setPlay(play);
        navigationView.push(playScene);

    }
}
