package ui.scene;

import logic.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a PlayerCreationScene to show the scene for creating player name which extends Scene class
 * @author Siyu Chen
 * @version 0.1
 */
public class PlayerCreationScene extends Scene {

    private Player player;

    public Player getPlayer() {
        return player;
    }

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

    private JLabel label;
    private JTextField textField;
    private JButton button;

    private JTextField nameField;
    private JTextField levelField;
    private JButton createButton;
    private JButton setButton;
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

        button = new JButton("Set");
        button.setSize(160, 40);
        button.setLocation(320, 70);
        contentView.add(button);
        setButton = button;

        button = new JButton(Player.PLAYER_TYPE_BULLY);
        button.setSize(160, 40);
        button.setLocation(150, 130);
        contentView.add(button);
        bullyButton = button;

        button = new JButton(Player.PLAYER_TYPE_NIMBLE);
        button.setSize(160, 40);
        button.setLocation(320, 130);
        contentView.add(button);
        nimbleButton = button;

        button = new JButton(Player.PLAYER_TYPE_TANK);
        button.setSize(160, 40);
        button.setLocation(490, 130);
        contentView.add(button);
        bullyButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(150, 190);
        contentView.add(button);
        createButton = button;

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerCreationScene.this.navigationView.pop();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerEditingScene playerEditingScene = new PlayerEditingScene();
//                Player player = new Player();
                player.setName(nameField.getText());
                playerEditingScene.setPlayer(player);
                PlayerCreationScene.this.navigationView.push(playerEditingScene);


            }
        });
    }
}
