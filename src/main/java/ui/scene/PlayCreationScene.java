package ui.scene;

import logic.Campaign;
import logic.Play;
import logic.Player;
import ui.panel.CampaignDelegate;
import ui.panel.CampaignSelectorPanel;
import ui.panel.PlayerDelegate;
import ui.panel.PlayerSelectorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayCreationScene extends Scene implements PlayerDelegate, CampaignDelegate {

    Play play = new Play();

    @Override
    protected void init() {
        super.init();

        title = "Create Play";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }


    JLabel playerNameLabel;
    JLabel campaignNameLabel;


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
                ReadyScene readyScene = new ReadyScene();
                play.setName(playNameTextField.getText());
                readyScene.setPlay(play);
                PlayCreationScene.this.navigationView.push(readyScene);
            }
        });
    }

    private void selectPlayer() {
        PlayerSelectorPanel playerSelectorPanel = new PlayerSelectorPanel();
        playerSelectorPanel.setLocation(460, 80);
        playerSelectorPanel.setButtonText("Select");
        playerSelectorPanel.setPlayerDelegate(this);
        contentView.add(playerSelectorPanel);
    }

    @Override
    public void playerSelectorPerformAction(PlayerSelectorPanel playerSelectorPanel, Player player) {
        remove(playerSelectorPanel);

        play.setPlayer(player);
        playerNameLabel.setText(player.getName());
    }

    private void selectCampaign() {
        CampaignSelectorPanel campaignSelectorPanel = new CampaignSelectorPanel();
        campaignSelectorPanel.setLocation(460, 130);
        campaignSelectorPanel.setButtonText("Select");
        campaignSelectorPanel.setCampaignDelegate(this);
        contentView.add(campaignSelectorPanel);
    }

    @Override
    public void campaignSelectorPerformAction(CampaignSelectorPanel campaignSelectorPanel, Campaign campaign) {
        remove(campaignSelectorPanel);

        play.setCampaign(campaign);
        campaignNameLabel.setText(campaign.getName());
    }



}
