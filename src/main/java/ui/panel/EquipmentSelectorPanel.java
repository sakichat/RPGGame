package ui.panel;

import game.Equipment;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import game.Simulation;
import persistence.EquipmentFileManager;
import ui.view.*;

/**
 * @author Li Zhen
 * @version 0.1
 */

/**
 * this class is to create panel to searchButton equipment to add to player
 */
public class EquipmentSelectorPanel extends Panel {

    private EquipmentDelegate equipmentDelegate;

    public EquipmentDelegate getEquipmentDelegate() {
        return equipmentDelegate;
    }

    public void setEquipmentDelegate(EquipmentDelegate equipmentDelegate) {
        this.equipmentDelegate = equipmentDelegate;
    }

    private JTextField textField;
    private JButton searchButton;

    @Override
    protected void init() {
        super.init();

        setSize(520, 170);
        title = "Equipment Selector";
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

        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setLocation(310,30);
        searchButton.setSize(100,40);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });



    }

    private void search(){
        EquipmentFileManager.allName();
        List<Equipment> list = Simulation.getEquipments();
        int number = 0;
        int yOfView = 80;
        int xOfView = 140;



        for (Equipment equipment : list){
            if (equipment.getName().contains(textField.getText()) && number < 3){
                EquipmentView equipmentView = new EquipmentView();
                equipmentView.setLocation(xOfView,yOfView);
                add(equipmentView);
                equipmentView.setEquipment(equipment);

                JButton addButton = new JButton("Add");
                addButton.setLocation(450,yOfView);
                addButton.setSize(60,20);
                add(addButton);

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        equipmentDelegate.equipmentDelegate(equipment);
                    }
                });

                number++;
                yOfView += 30;
            }
        }
        repaint();
    }



}
