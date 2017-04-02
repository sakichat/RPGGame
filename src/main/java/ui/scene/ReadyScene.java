package ui.scene;

import logic.Play;
import ui.panel.PlaySelectorPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This ReadyScene means players have already created a play within player and campaign.
 * @author Siyu Chen
 * @version 0.2
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
     * This parameter is for the label of playName.
     */
    JLabel playNameLabel;
    JButton newGameButton;
    JButton loadGameButton;

    /**
     * This method creates components on this scene
     * And adds events on buttons
     */
    protected void initSubviews() {

        label = new JLabel("Play");
        label.setSize(160, 40);
        label.setLocation(20, 20);
        contentView.add(label);
        playNameLabel = label;

        button = new JButton("New");
        button.setSize(160, 40);
        button.setLocation(20, 70);
        contentView.add(button);
        newGameButton = button;

        button = new JButton("Load");
        button.setSize(160, 40);
        button.setLocation(20, 130);
        contentView.add(button);
        loadGameButton = button;

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadyScene.this.navigationView.pop();
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayCreationScene playCreationScene = new PlayCreationScene();
                ReadyScene.this.navigationView.push(playCreationScene);
            }
        });

        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlaySelectorPanel playSelectorPanel = new PlaySelectorPanel();
                playSelectorPanel.setLocation(20, 170);
                contentView.add(playSelectorPanel);
            }
        });

        repaint();
    }

    @Override
    public void playSelectorPerformAction(PlaySelectorPanel playSelectorPanel, Play play) {
        
    }
}
