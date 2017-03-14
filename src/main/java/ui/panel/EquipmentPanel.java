package ui.panel;

import logic.Chest;
import logic.Equipment;
import logic.Player;
import ui.view.EquipmentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * This is a view class extends Panel, and implements Observer
 * @author Qi Xia
 * @version 0.2
 */
public class EquipmentPanel extends Panel implements Observer{

    /**
     * Chest attribute
     */
    private Chest chest;

    /**
     * This method is the chest getter
     * @return Chest
     */
    public Chest getChest() {
        return chest;
    }

    /**
     * This method is the chest setter
     * call dataToView and addObserver
     * @param chest
     */
    public void setChest(Chest chest) {
        this.chest = chest;
        dataToView();
        chest.addObserver(this);
    }

    /**
     * Player attribute and getter & setter
     */

    private Player player;

    /**
     * This method is the Player getter.
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player Player
     * call dataToView and addOberserver
     */

    public void setPlayer(Player player) {
        this.player = player;
        dataToView();
        player.addObserver(this);
    }

    private JPanel equipmentsPanel;

    /**
     * This method is init method.
     */
    @Override
    protected void init() {
        super.init();

        setSize(460, 330);
        title = "Equipments";
    }

    /**
     * This is a method makes initialized.
     */

    protected void initSubviews(){
        equipmentsPanel = new JPanel();
        equipmentsPanel.setLayout(null);
        equipmentsPanel.setSize(460, 310);
        equipmentsPanel.setLocation(0, 20);
        add(equipmentsPanel);
    }

    /**
     *
     * @param observer Observable
     * @param x Object
     * Observer method, update change
     */

    @Override
    public void update(Observable observer, Object x) {

        boolean change = false;
        change = change || (x == Player.BACKPACK_CHANGE);

        if (change) {
            dataToView();
        }
    }

    /**
     * This is a method makes data transfer to view
     */

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

            JButton dropButtton = new JButton("drop");

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
