package ui.scene;

import logic.Campaign;
import logic.Play;
import logic.PlayRuntime;
import logic.player.Player;
import logic.turn.TurnStrategyComputer;
import logic.turn.TurnStrategyHuman;
import ui.panel.CampaignSelectorPanel;
import ui.panel.PlayerSelectorPanel;

import javax.swing.*;
import java.awt.*;

/**
 * This class extends Scene and implements PlayerDelegate and CampaignDelegate.
 * It is for creating a play with selected player and selected campaign.
 * @author Siyu Chen
 * @version 0.2
 */
public class PlayCreationScene extends Scene implements PlayerSelectorPanel.Delegate, CampaignSelectorPanel.Delegate {

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
    JLabel playerModeLabel;

    public final static String HUMAN_PLAYER_MODE        = "Human Player";
    public final static String COMPUTER_PLAYER_MODE     = "Computer Player";

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

        label = new JLabel("Player Mode", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 140);
        contentView.add(label);

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 140);
        contentView.add(label);
        label.setOpaque(true);
        label.setBackground(new Color(0xf4f4f4));
        playerModeLabel = label;

        button = new JButton("Human Player");
        button.setSize(160, 40);
        button.setLocation(150, 190);
        contentView.add(button);
        JButton humanPlayerModeButton = button;

        button = new JButton("Computer Player");
        button.setSize(160, 40);
        button.setLocation(320, 190);
        contentView.add(button);
        JButton computerPlayerModeButton = button;

        label = new JLabel("Campaign", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 250);
        contentView.add(label);

        label = new JLabel("", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 250);
        contentView.add(label);
        label.setOpaque(true);
        label.setBackground(new Color(0xf4f4f4));
        campaignNameLabel = label;

        button = new JButton("Select");
        button.setSize(120, 40);
        button.setLocation(320, 250);
        contentView.add(button);
        JButton campaignSelectButton = button;

        button = new JButton("Create");
        button.setSize(120, 40);
        button.setLocation(150, 310);
        contentView.add(button);
        JButton createButton = button;

        repaint();

        backButton.addActionListener(e -> PlayCreationScene.this.navigationView.pop());

        playerSelectButton.addActionListener(e -> selectPlayer());

        humanPlayerModeButton.addActionListener(e -> playerModeLabel.setText(HUMAN_PLAYER_MODE));

        computerPlayerModeButton.addActionListener(e -> playerModeLabel.setText(COMPUTER_PLAYER_MODE));

        campaignSelectButton.addActionListener(e -> selectCampaign());

        createButton.addActionListener(e -> {
            PlayScene playScene = new PlayScene();
            play.setName(playNameTextField.getText());

            PlayRuntime playRuntime = PlayRuntime.currentRuntime();

            playRuntime.initiate(playScene, play);
            PlayCreationScene.this.navigationView.push(playScene);
            playRuntime.begin();

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

        player.setPlayerParty(Player.PLAYER_PARTY_MAIN);
        play.setMainPlayer(player);
        playerNameLabel.setText(player.getName());

        if (playerModeLabel.getText().equals(HUMAN_PLAYER_MODE)){
            TurnStrategyHuman turnStrategyHuman = new TurnStrategyHuman();
            player.setStrategy(turnStrategyHuman);
        }else if (playerModeLabel.getText().equals(COMPUTER_PLAYER_MODE)){
            TurnStrategyComputer turnStrategyComputer = new TurnStrategyComputer();
            player.setStrategy(turnStrategyComputer);
        }

    }

    /**
     * This method sets a CampaignSelectorPanel on this scene.
     */
    private void selectCampaign() {
        CampaignSelectorPanel campaignSelectorPanel = new CampaignSelectorPanel();
        campaignSelectorPanel.setLocation(460, 250);
        campaignSelectorPanel.setButtonText("Select");
        campaignSelectorPanel.setDelegate(this);
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
