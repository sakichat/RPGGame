package ui.panel;

import logic.equipment.Equipment;

import javax.swing.*;
import java.util.List;

import persistence.EquipmentFileManager;
import ui.view.*;

/**
 * @author Li Zhen
 * @version 0.1
 */

/**
 * this class is to create panel to searchButton equipment to add to currentPlayer
 */
public class EquipmentSelectorPanel extends Panel {

    /**
     * inner class of delegate.
     */
    public interface Delegate {
        /**
         * this method is to define the abstract method which is implemented by implemented class.
         * @param selectorPanel EquipmentSelectorPanel
         * @param equipment Equipment
         */
        void equipmentSelectorPerformAction(EquipmentSelectorPanel selectorPanel, Equipment equipment);

    }

    /**
     * delegate
     */
    /**
     * declaration of delegate
     */
    private Delegate delegate;

    /**
     * Getter for delegate
     * @return
     */
    public Delegate getDelegate() {
        return delegate;
    }

    /**
     * Setter for delegate
     * @param delegate
     */
    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }


    private View equipmentPanel;
    private String buttonText;

    /**
     *
     * @return
     */
    public String getButtonText() {
        return buttonText;
    }

    /**
     * Setter for buttonText
     * @param buttonText
     */
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
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
     * layout
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

        searchButton.addActionListener(e -> {
            equipmentPanel.removeAll();
            search();
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

                addButton.addActionListener(e ->
                    delegate.equipmentSelectorPerformAction(EquipmentSelectorPanel.this, equipment)
                );

                number++;
                yOfView += 30;
            }
        }
        repaint();
    }



}
