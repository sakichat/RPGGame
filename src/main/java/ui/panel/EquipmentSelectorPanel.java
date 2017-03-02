package ui.panel;

import game.Equipment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import persistence.EquipmentFileManager;
import ui.scene.EditorScene;
import ui.scene.PlayerEditingScene;
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
    private View equipmentPanel;
    private String buttonText;

    /**
     * this method is to set text of addButton
     * @param buttonText String
     */

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    /**
     * this method is to get EquipmentDelegate
     * @return EquipmentDelegate
     */

    public EquipmentDelegate getEquipmentDelegate() {
        return equipmentDelegate;
    }

    /**
     * this method is to set EquipmentDelegate
     * @param equipmentDelegate EquipmentDelegate
     */

    public void setEquipmentDelegate(EquipmentDelegate equipmentDelegate) {
        this.equipmentDelegate = equipmentDelegate;
    }

    private JTextField textField;
    private JButton searchButton;

    /**
     * this method is to initial the view
     */

    @Override
    protected void init() {
        super.init();

        setSize(390, 170);
        title = "Equipment Selector";

    }


    /**
     * this method is to create the  fixed view
     */


    protected void initSubviews(){
        equipmentPanel = new View();
        equipmentPanel.setLayout(null);
        equipmentPanel.setSize(380,90);
        equipmentPanel.setLocation(10,80);
        add(equipmentPanel);




        textField = new JTextField();
        textField.setLocation(10,30);
        textField.setSize(160,40);
        add(textField);

        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setLocation(180,30);
        searchButton.setSize(100,40);
        add(searchButton);



        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipmentPanel.removeAll();
                search();
            }
        });



    }
    /**
     * this method is to search the files
     */

    private void search(){
        List<String> names = EquipmentFileManager.allNames();
        int number = 0;
        int yOfView = 0;
        int xOfView = 0;



        for (String name : names){
            if (name.contains(textField.getText()) && number < 3){
                Equipment equipment = EquipmentFileManager.read(name);

                EquipmentView equipmentView = new EquipmentView();
                equipmentView.setLocation(xOfView,yOfView);
                equipmentPanel.add(equipmentView);
                equipmentView.setEquipment(equipment);

                JButton addButton = new JButton(buttonText);
                addButton.setLocation(310,yOfView);
                addButton.setSize(60,20);
                equipmentPanel.add(addButton);

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        equipmentDelegate.equipmentSelectorPerformAction(EquipmentSelectorPanel.this, equipment);
                    }
                });

                number++;
                yOfView += 30;
            }
        }
        repaint();
    }



}
