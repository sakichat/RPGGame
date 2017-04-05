package ui.view;

import logic.equipments.Equipment;
import logic.equipments.Weapon;

import javax.swing.*;

/**
 * @author Qi Xia
 * @version 0.2
 */
public class EquipmentView extends View {

    /**
     * The Equipment attribute and getter & setter
     */
    private Equipment equipment;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        dataToView();
    }

    /**
     * The JLabel attribute
     */
    public JLabel typeLabel;
    public JLabel nameLabel;
    public JLabel enhanceLabel;

    /**
     * Constructor
     */
    public EquipmentView(){
        this.setSize(300, 20);

        initSubviews();
    }

    /**
     * This is a method to make initialization
     */
    private void initSubviews(){

        JLabel label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(60, 20);
        label.setLocation(0, 0);
        add(label);
        typeLabel = label;

        label = new JLabel();
        label.setSize(160, 20);
        label.setLocation(70, 0);
        add(label);
        nameLabel = label;

        label = new JLabel();
        label.setSize(60, 20);
        label.setLocation(240, 0);
        add(label);
        enhanceLabel = label;
    }

    /**
     * This is a method to get data and transfer to view
     */
    private void dataToView(){

        typeLabel.setText(equipment.getType());
        if (equipment instanceof Weapon) {
            nameLabel.setText(equipment.displayName());
        } else {
            nameLabel.setText(equipment.getName());
        }

        String valueString = TextDisplay.signedNumber(equipment.getEnhancedValue());
        String attributeString = equipment.getEnhancedAttribute();
        enhanceLabel.setText(valueString + " " + attributeString);

    }
}
