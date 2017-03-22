package ui.scene;

import logic.Campaign;
import logic.Play;
import logic.Player;
import ui.panel.CampaignDelegate;
import ui.panel.CampaignSelectorPanel;
import ui.panel.PlayerSelectorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class extends Scene and implements PlayerDelegate and CampaignDelegate.
 * It is for creating a play with selected player and selected campaign.
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayCreationScene extends Scene implements PlayerSelectorPanel.Delegate, CampaignDelegate {

    /**
     * This parameter create a new Play().
     */
    Play play = new Play();

    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        title = "Create Play";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    /**
     * These parameters are for JLabels.
     */
    JLabel playerNameLabel;
    JLabel campaignNameLabel;

    /**
     * This method creates components on this scene
     * And adds events on buttons
     */
    public void initSubviews() {

        JLabel label;
        JButton button;

        label = new JLabel("Play", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        JTextField playNameTextField = new JTextField();
        playNameTextField.setSize(160, 40);
        playNameTextField.setLocation(150, 20);
        contentView.add(playNameTextField);

        label = new JLabel("Player", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 80);
        contentView.add(label);

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 80);
        contentView.add(label);
        label.setOpaque(true);
        label.setBackground(new Color(0xf4f4f4));
        playerNameLabel = label;

        button = new JButton("Select");
        button.setSize(120, 40);
        button.setLocation(320, 80);
        contentView.add(button);
        JButton playerSelectButton = button;

        label = new JLabel("Campaign", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 130);
        contentView.add(label);

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 130);
        contentView.add(label);
        label.setOpaque(true);
        label.setBackground(new Color(0xf4f4f4));
        campaignNameLabel = label;

        button = new JButton("Select");
        button.setSize(120, 40);
        button.setLocation(320, 130);
        contentView.add(button);
        JButton campaignSelectButton = button;

        button = new JButton("Create");
        button.setSize(120, 40);
        button.setLocation(150, 190);
        contentView.add(button);
        JButton createButton = button;

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayCreationScene.this.navigationView.pop();
            }
        });

        playerSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectPlayer();
            }
        });

        campaignSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectCampaign();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayScene playScene = new PlayScene();
                play.setName(playNameTextField.getText());
                play.resolveMap();
                playScene.setPlay(play);
                PlayCreationScene.this.navigationView.push(playScene);
            }
        });
    }

    /**
     * This method sets a PlayerSelectorPanel on this scene.
     */
    private void selectPlayer() {
        PlayerSelectorPanel playerSelectorPanel = new PlayerSelectorPanel();
        playerSelectorPanel.setLocation(460, 80);
        playerSelectorPanel.setButtonText("Select");
        playerSelectorPanel.setDelegate(this);
        contentView.add(playerSelectorPanel);
    }

    /**
     * This method is for PlayerDelegate.
     * @param playerSelectorPanel PlayerSelectorPanel
     * @param player Player
     */
    @Override
    public void playerSelectorPerformAction(PlayerSelectorPanel playerSelectorPanel, Player player) {
        contentView.remove(playerSelectorPanel);

        player.setPlayerParty(Player.PLAYER_PARTY_PLAYER);
        play.setPlayer(player);
        playerNameLabel.setText(player.getName());
    }

    /**
     * This method sets a CampaignSelectorPanel on this scene.
     */
    private void selectCampaign() {
        CampaignSelectorPanel campaignSelectorPanel = new CampaignSelectorPanel();
        campaignSelectorPanel.setLocation(460, 130);
        campaignSelectorPanel.setButtonText("Select");
        campaignSelectorPanel.setCampaignDelegate(this);
        contentView.add(campaignSelectorPanel);
    }

    /**
     * This method is for CampaignDelegate.
     * @param campaignSelectorPanel CampaignSelectorPanel
     * @param campaign Campaign
     */
    @Override
    public void campaignSelectorPerformAction(CampaignSelectorPanel campaignSelectorPanel, Campaign campaign) {
        contentView.remove(campaignSelectorPanel);

        play.setCampaign(campaign);
        campaignNameLabel.setText(campaign.getName());
    }

}
