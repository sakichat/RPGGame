package ui.panel;

import logic.Player;
import persistence.PlayerFileManager;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * this class is the panel of playerSelector
 */
public class PlayerSelectorPanel extends Panel {
    private JTextField textField;
    private JButton searchButton;
    private View playerSelector;
    private PlayerDelegate playerDelegate;
    private String buttonText;

    /**
     *this method is to set text of addButton
     * @param buttonText String
     */

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    /**
     * this method is to get playerDelegate
     * @return PlayerDelegate
     */

    public PlayerDelegate getPlayerDelegate() {
        return playerDelegate;
    }

    /**
     * this method is to set PlayerDelegate
     * @param playerDelegate PlayerDelegate
     */

    public void setPlayerDelegate(PlayerDelegate playerDelegate) {
        this.playerDelegate = playerDelegate;
    }

    /**
     * this method is to initial the view
     */

    @Override
    protected void init() {
        super.init();
        title = "Player Selector";
        setSize(290,170);
    }

    /**
     * this method is to set sub-views
     */

    @Override
    protected void initSubviews() {
        playerSelector = new View();
        playerSelector.setLayout(null);
        playerSelector.setLocation(10,80);
        playerSelector.setSize(290,90);
        add(playerSelector);

        textField = new JTextField();
        textField.setLayout(null);
        textField.setSize(160,40);
        textField.setLocation(10,30);
        add(textField);

        searchButton = new JButton("Search");
        searchButton.setLayout(null);
        searchButton.setSize(100,40);
        searchButton.setLocation(180,30);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerSelector.removeAll();
                search();
            }
        });

    }

    /**
     * this method is to search the files
     */

    public void search(){
        List<String> names = PlayerFileManager.allNames();
        int number = 0;
        int yOfView = 0;
        int xOfView = 0;



        for (String name : names){
            if (name.contains(textField.getText()) && number < 3){
                Player player = PlayerFileManager.read(name);

                JLabel playerLabel = new JLabel();
                playerLabel.setLayout(null);
                playerLabel.setSize(160,20);
                playerLabel.setLocation(xOfView,yOfView);
                playerLabel.setText(player.getName());
                playerSelector.add(playerLabel);

                JButton addButton = new JButton(buttonText);
                addButton.setLocation(170,yOfView);
                addButton.setSize(60,20);
                playerSelector.add(addButton);

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playerDelegate.playerSelectorPerformAction(PlayerSelectorPanel.this,player);
                    }
                });

                number++;
                yOfView += 30;
            }
        }
        repaint();
    }
}
