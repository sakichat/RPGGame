package ui.panel;

import game.Equipment;
import game.Player;
import game.Simulation;
import ui.view.EquipmentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Qi Xia
 */
public class BackpackPanel extends JPanel implements Observer{
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        dataToView();
        player.addObserver(this);
    }

    private JPanel equipmentsPanel;

    public BackpackPanel(){
        this.setLayout(null);
        this.setSize(460, 330);

        initSubviews();
    }

    private void initSubviews(){
        JLabel label = new JLabel("Backpack", JLabel.CENTER);
        label.setSize(460, 20);
        label.setLocation(0, 0);
        this.add(label);

        equipmentsPanel = new JPanel();
        equipmentsPanel.setLayout(null);
        equipmentsPanel.setSize(460, 310);
        equipmentsPanel.setLocation(0, 20);
        add(equipmentsPanel);
    }

    @Override
    public void update(Observable observer, Object x) {

        boolean change = false;
        change = change || (x == Player.BACKPACK_CHANGE);

        if (change) {
            dataToView();
        }
    }

    public void dataToView(){
        equipmentsPanel.removeAll();


        int x = 10;
        int y = 10;

        List<Equipment> backpack;
        backpack = player.equipmentsInBackpack();

        for (Equipment equipment : backpack) {
            EquipmentView equipmentView = new EquipmentView();
            equipmentView.setLocation(x, y);
            equipmentsPanel.add(equipmentView);
            equipmentView.setEquipment(equipment);

            JButton equipButton = new JButton("equip");
            JButton dropButtton = new JButton("drop");

            equipButton.setSize(60, 20);
            equipButton.setLocation(310, y);
            equipmentsPanel.add(equipButton);
            equipButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.equip(equipment);
                }
            });

            dropButtton.setSize(60, 20);
            dropButtton.setLocation(380, y);
            equipmentsPanel.add(dropButtton);
            dropButtton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.dropEquipment(equipment);
                }
            });

            y += 30;
        }

        repaint();
    }
}
