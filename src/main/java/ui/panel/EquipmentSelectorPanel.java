package ui.panel;

import game.Equipment;
import game.Player;
import game.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import ui.view.*;

/**
 * @author Li Zhen
 * @version 0.1
 */

/**
 * this class is to create panel to search equipment to add to player
 */
public class EquipmentSelectorPanel extends Panel {
    private Player player = Simulation.newPlayer();
    private JTextField textField;
    private JButton search;
    private EquipmentDelegate equipmentDelegate;

    public EquipmentDelegate getEquipmentDelegate() {
        return equipmentDelegate;
    }

    public void setEquipmentDelegate(EquipmentDelegate equipmentDelegate) {
        this.equipmentDelegate = equipmentDelegate;
    }

    @Override
    protected void init() {
        super.init();

        setSize(520, 170);
        title = "Equipment Selector";
    }

    /**
     * this method is to return a Player
     * @return Player
     */

    public Player getPlayer() {
        return player;
    }

    /**
     * this method is to set Player
     * @param player Player
     */

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * this method is to set Player
     * @param player Player
     */

    public void givePlayer(Player player){
        this.player = player;
    }

    /**
     * this method is to add euiqpment to Player
     */
    public void dataToView(){



    }

    /**
     * this method is to create the  fixed view
     */


    protected void initSubviews(){
        JLabel title = new JLabel("Character");
        title.setLocation(0,0);
        title.setSize(520,20);
        title.setBackground(new Color(244,244,244));
        add(title);

        JLabel itemName = new JLabel("Item");
        itemName.setLocation(10,30);
        itemName.setSize(120,40);
        itemName.setBackground(new Color(236,245,248));
        add(itemName);


        textField = new JTextField();
        textField.setLocation(140,30);
        textField.setSize(160,40);
        add(textField);

        search = new JButton();
        search.setText("Search");
        search.setLocation(310,30);
        search.setSize(100,40);
        add(search);

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });



    }

    private void search(){
        List<Equipment> list = player.equipmentsInBackpack();
        int number = 0;
        int yOfView = 80;
        int xOfView = 140;
        for (Equipment equipment : list){
            if (equipment.getName().equals(textField.getText()) && number < 3){
                EquipmentView equipmentView = new EquipmentView();
                equipmentView.setLocation(xOfView,yOfView);
                JButton addButton = new JButton("Add");
                addButton.setLocation(450,yOfView);
                addButton.setSize(60,20);
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        equipmentDelegate.equipmentDelegate(equipment);
                    }
                });
                EquipmentSelectorPanel.this.add(equipmentView);
                EquipmentSelectorPanel.this.add(addButton);

                number++;
                yOfView += 30;

            }
        }
    }



}
