package ui.panel;

import ui.panel.Panel;

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

    @Override
    protected void init() {
        super.init();

        w = 520;
        h = 170;
        titleName = "Equipment Selector";
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

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                                player.pickUpEquipment(equipment);
                            }
                        });
                        EquipmentSelectorPanel.this.add(equipmentView);
                        EquipmentSelectorPanel.this.add(addButton);

                        number++;
                        yOfView += 30;

                    }
                }

            }
        });

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




    }

}
