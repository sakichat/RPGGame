package ui.view;

import game.Equipment;

import javax.swing.*;

/**
 * @author Qi Xia
 */
public class EquipmentView extends JPanel {

    private Equipment equipment;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        dataToView();
    }

    public JLabel typeLabel;
    public JLabel nameLabel;
    public JLabel enhanceLabel;

    public EquipmentView(){
        this.setLayout(null);
        this.setSize(300, 20);

        initSubviews();
    }

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

    private void dataToView(){
        typeLabel.setText(equipment.getType());
        nameLabel.setText(equipment.getName());

        String valueString = TextDisplay.signedNumber(equipment.getEnhancedValue());
        String attributeString = equipment.getEnhancedAttribute();
        enhanceLabel.setText(valueString + " " + attributeString);

    }
}
