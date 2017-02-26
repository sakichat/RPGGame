package demo.ui;

import game.Simulation;
import ui.panel.PlayerPanel;

import javax.swing.*;

/**
 * Created by Kai QI on 2017/2/24.
 */
public class PlayerPanelDemo extends JFrame {
    public static void main(String[] args) {
        PlayerPanelDemo window = new PlayerPanelDemo();
        window.setSize(200, 50);
        window.setLayout(null);
        window.setVisible(true);

    }
    public PlayerPanelDemo(){
        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setLocation(0, 20);

        playerPanel.setPlayer(Simulation.newPlayer());
        playerPanel.dataToView();

        this.add(playerPanel);
        repaint();


    }
}
