package ui.scene;

import logic.player.*;

import javax.swing.*;
import java.awt.*;

/**
 * This is a PlayerCreationScene to show the scene for creating currentPlayer name which extends Scene class
 * @author Siyu Chen
 * @version 0.3
 */
public class PlayerCreationScene extends Scene {

    /**
     * This parameter sets a currentPlayer in this Scene.
     */
    private Player player;

    /**
     * This is a getter for currentPlayer.
     * @return currentPlayer
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This is a setter for currentPlayer.
     * @param player Player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    protected void init() {
        super.init();

        title = "Create Player";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    /**
     * These parameters are specific for components on this scene.
     */
    private JLabel label;
    private JTextField textField;
    private JButton button;

    private JTextField nameField;
    private JTextField levelField;
    private JLabel checkLevelLabel;
    private JLabel typeLabel;
    private JButton createButton;
    private JButton bullyButton;
    private JButton nimbleButton;
    private JButton tankButton;

    /**
     * This method creates components on the main scene
     * And adds events on backButton and createButton
     */
    protected void initSubviews() {
        label = new JLabel("Name", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        textField = new JTextField();
        textField.setSize(160,40);
        textField.setLocation(150, 20);
        contentView.add(textField);
        nameField = textField;

        label = new JLabel("Level", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 70);
        contentView.add(label);

        textField = new JTextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 70);
        contentView.add(textField);
        levelField = textField;

        label = new JLabel("");
        label.setSize(300, 40);
        label.setLocation(320, 70);
        contentView.add(label);
        checkLevelLabel = label;

        label = new JLabel("Fighter Type", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 130);
        contentView.add(label);

        label = new JLabel("");
        label.setSize(160, 40);
        label.setLocation(150, 130);
        label.setOpaque(true);
        label.setBackground(new Color(0xf4f4f4));
        contentView.add(label);
        typeLabel = label;

        button = new JButton(Player.PLAYER_TYPE_BULLY);
        button.setSize(160, 40);
        button.setLocation(150, 180);
        contentView.add(button);
        bullyButton = button;

        button = new JButton(Player.PLAYER_TYPE_NIMBLE);
        button.setSize(160, 40);
        button.setLocation(320, 180);
        contentView.add(button);
        nimbleButton = button;

        button = new JButton(Player.PLAYER_TYPE_TANK);
        button.setSize(160, 40);
        button.setLocation(490, 180);
        contentView.add(button);
        tankButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(150, 240);
        contentView.add(button);
        createButton = button;

        repaint();

        backButton.addActionListener(e -> PlayerCreationScene.this.navigationView.pop());

        bullyButton.addActionListener(e -> typeLabel.setText(Player.PLAYER_TYPE_BULLY));

        nimbleButton.addActionListener(e -> typeLabel.setText(Player.PLAYER_TYPE_NIMBLE));

        tankButton.addActionListener(e -> typeLabel.setText(Player.PLAYER_TYPE_TANK));

        createButton.addActionListener(e -> {
            int level = Integer.parseInt(levelField.getText());

            if (level < 1) {
                checkLevelLabel.setText("Level CANNOT less than 1!");

            } else if (level > 20) {
                checkLevelLabel.setText("Level CANNOT larger than 20!");

            } else {
                PlayerExplorer playerExplorer;

                String name = nameField.getText();
                String type = typeLabel.getText();

                PlayerBuilder playerBuilder = null;
                if (type.equals(Player.PLAYER_TYPE_BULLY)){
                    playerBuilder = new PlayerBuilderBully();
                }else if (type.equals(Player.PLAYER_TYPE_NIMBLE)){
                    playerBuilder = new PlayerBuilderNimble();
                }else if(type.equals(Player.PLAYER_TYPE_TANK)){
                    playerBuilder = new PlayerBuilderTank();
                }

                playerExplorer = new PlayerExplorer();
                playerExplorer.setPlayerBuilder(playerBuilder);
                playerExplorer.constructPlayer(name,level);
                player = playerExplorer.getPlayer();

                PlayerEditingScene playerEditingScene = new PlayerEditingScene();
                playerEditingScene.setPlayer(player);
                PlayerCreationScene.this.navigationView.push(playerEditingScene);
            }
        });
    }
}
