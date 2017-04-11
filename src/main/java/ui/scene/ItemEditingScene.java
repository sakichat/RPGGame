package ui.scene;

import logic.equipment.*;
import logic.player.Player;
import org.apache.commons.lang3.text.WordUtils;
import persistence.EquipmentFileManager;
import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author GU_HAN
 * @version 0.2
 *
 * This scene is for editing the equipments.
 */
public class ItemEditingScene extends Scene {

    private Equipment equipment;
    private boolean weaponSubPanelEnabeld;

    public boolean isWeaponSubPanelEnabeld() {
        return weaponSubPanelEnabeld;
    }

    public void setWeaponSubPanelEnabeld(boolean weaponSubPanelEnabeld) {
        this.weaponSubPanelEnabeld = weaponSubPanelEnabeld;
    }

    /**
     * This method is for get the equipment.
     * @return equipment.
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * This method is for set up the equipment.
     * @param equipment
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        if(equipment.getType() == null){
            equipment.setType(Equipment.HELMET);
        }
        if(equipment.getEnhancedAttribute() == null){
            equipment.setEnhancedAttribute(Player.ABILITY_STR);
        }
        if (equipment instanceof Weapon) {
            setWeaponSubPanelEnabeld(true);
        }
        dataToView();
    }



    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel enhanceOnLabel;
    private JLabel weaponTypeLabel;
    private JTextField valueTextField;

    private JPanel weaponSubPanel;
    private JTextField rangeTextField;
    private JLabel effectsValueLabel;

    /**
     * This method is for initialization.
     */
    @Override
    protected void init() {
        super.init();

        title = "Edit Item";
        backButtonEnabled = true;
        saveButtonEnabled = true;

    }

    /**
     * This method is the details of the initialization.
     */
    protected void initSubviews(){

        saveButton.setEnabled(false);

        JLabel label;
        JButton button;
        JTextField textField;

        label = new JLabel("Name", JLabel.RIGHT);
        label.setSize(120, 30);
        label.setLocation(20, 20);
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 30);
        label.setLocation(150, 20);
        contentView.add(label);
        nameLabel = label;

        label = new JLabel("Type", JLabel.RIGHT);
        label.setSize(120, 30);
        label.setLocation(20, 60);
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 30);
        label.setLocation(150, 60);
        contentView.add(label);
        typeLabel = label;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(150, 100);
        button.setText(Equipment.HELMET);
        contentView.add(button);
        JButton helmetButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(240, 100);
        button.setText(Equipment.ARMOR);
        contentView.add(button);
        JButton armorButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(330, 100);
        button.setText(Equipment.SHIELD);
        contentView.add(button);
        JButton shieldButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(420, 100);
        button.setText(Equipment.RING);
        contentView.add(button);
        JButton ringButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(510, 100);
        button.setText(Equipment.BELT);
        contentView.add(button);
        JButton beltButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(600, 100);
        button.setText(Equipment.BOOTS);
        contentView.add(button);
        JButton bootsButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(690, 100);
        button.setText(Equipment.WEAPON);
        JButton weaponButton = button;
        contentView.add(button);

        label = new JLabel("Enhance On", JLabel.RIGHT);
        label.setSize(120, 30);
        label.setLocation(20, 140);
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 30);
        label.setLocation(150, 140);
        contentView.add(label);
        enhanceOnLabel = label;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(150, 180);
        button.setText(Player.ABILITY_STR);
        contentView.add(button);
        JButton strButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(240, 180);
        button.setText(Player.ABILITY_DEX);
        contentView.add(button);
        JButton dexButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(330, 180);
        button.setText(Player.ABILITY_CON);
        contentView.add(button);
        JButton conButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(420, 180);
        button.setText(Player.ABILITY_INT);
        contentView.add(button);
        JButton intButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(510, 180);
        button.setText(Player.ABILITY_WIS);
        contentView.add(button);
        JButton wisButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(600, 180);
        button.setText(Player.ABILITY_CHA);
        contentView.add(button);
        JButton chaButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(690, 180);
        button.setText(Player.ATTRIBUTE_ARMOR_CLASS);
        contentView.add(button);
        JButton armorClassButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(780, 180);
        button.setText(Player.ATTRIBUTE_ATTACK_BONUS);
        contentView.add(button);
        JButton attackBonusButton = button;

        button = new JButton();
        button.setSize(80, 30);
        button.setLocation(870, 180);
        button.setText(Player.ATTRIBUTE_DAMAGE_BONUS);
        contentView.add(button);
        JButton damageBonusButton = button;

        label = new JLabel("Value", JLabel.RIGHT);
        label.setSize(120, 30);
        label.setLocation(20, 220);
        contentView.add(label);

        textField = new JTextField();
        textField.setSize(160, 30);
        textField.setLocation(150, 220);
        contentView.add(textField);
        valueTextField = textField;

        button = new JButton("Set");
        button.setSize(120, 30);
        button.setLocation(320, 220);
        contentView.add(button);
        JButton valueSetButton = button;

        button = new JButton("Validate");
        button.setSize(160, 40);
        button.setLocation(150, 490);
        contentView.add(button);
        JButton validateButton = button;

        label = new JLabel();
        label.setSize(500, 40);
        label.setLocation(350, 490);
        contentView.add(label);
        JLabel validateResultLabel = label;

        weaponSubPanel = new View();
        weaponSubPanel.setSize(1000, 190);
        weaponSubPanel.setLocation(0, 260);
        weaponSubPanel.setBackground(new Color(0xFFFFFF));
//        if (weaponSubPanelEnabeld) {
//            contentView.add(weaponSubPanel);
//        }

        label = new JLabel("Weapon", JLabel.RIGHT);
        label.setSize(120, 30);
        label.setLocation(20, 0);
        weaponSubPanel.add(label);

        label = new JLabel();
        label.setSize(200, 30);
        label.setLocation(150, 0);
        weaponSubPanel.add(label);
        weaponTypeLabel = label;

        button = new JButton("Melee");
        button.setSize(80, 30);
        button.setLocation(150, 40);
        weaponSubPanel.add(button);
        JButton meleeTypeButton = button;

        button = new JButton("Ranged");
        button.setSize(80, 30);
        button.setLocation(240, 40);
        weaponSubPanel.add(button);
        JButton rangedTypeButton = button;

        label = new JLabel("Range", JLabel.RIGHT);
        label.setSize(120, 30);
        label.setLocation(20, 80);
        weaponSubPanel.add(label);

        textField = new JTextField();
        textField.setSize(160, 30);
        textField.setLocation(150, 80);
        weaponSubPanel.add(textField);
        rangeTextField = textField;

        button = new JButton("Set");
        button.setSize(120, 30);
        button.setLocation(320, 80);
        weaponSubPanel.add(button);
        JButton rangeSetButton = button;

        label = new JLabel("Effects", JLabel.RIGHT);
        label.setSize(120, 30);
        label.setLocation(20, 120);
        weaponSubPanel.add(label);

        label = new JLabel();
        label.setSize(710, 30);
        label.setLocation(150, 120);
        weaponSubPanel.add(label);
        effectsValueLabel = label;

        button = new JButton("Reset");
        button.setSize(80, 30);
        button.setLocation(870, 120);
        weaponSubPanel.add(button);
        JButton resetButton = button;

        button = new JButton("Freezing");
        button.setSize(120, 30);
        button.setLocation(150, 160);
        weaponSubPanel.add(button);
        JButton freezingButton = button;

        button = new JButton("Burning");
        button.setSize(120, 30);
        button.setLocation(280, 160);
        weaponSubPanel.add(button);
        JButton burningButton = button;

        button = new JButton("Slaying");
        button.setSize(120, 30);
        button.setLocation(410, 160);
        weaponSubPanel.add(button);
        JButton slayingButton = button;

        button = new JButton("Frightening");
        button.setSize(120, 30);
        button.setLocation(540, 160);
        weaponSubPanel.add(button);
        JButton frighteningButton = button;

        button = new JButton("Pacifying");
        button.setSize(120, 30);
        button.setLocation(670, 160);
        weaponSubPanel.add(button);
        JButton pacifyingButton = button;

        /*
         * add Listener
         */
        backButton.addActionListener(e ->
            ItemEditingScene.this.navigationView.popTo(EditorScene.class)
        );

        saveButton.addActionListener(e -> save());

        weaponButton.addActionListener(e -> {
            equipment.setType(Equipment.WEAPON);
            typeLabel.setText(Equipment.WEAPON);

            contentView.add(weaponSubPanel);

            EquipmentFactory equipmentFactory = new EquipmentFactory();
            equipment = equipmentFactory.equipmentToWeapon(equipment);

            dataToView();
        });

        shieldButton.addActionListener(e -> {
            equipment.setType(Equipment.SHIELD);
            typeLabel.setText(Equipment.SHIELD);

            if (equipment instanceof Weapon) {
                contentView.remove(weaponSubPanel);
                EquipmentFactory equipmentFactory = new EquipmentFactory();
                equipment = equipmentFactory.WeaponToEquipment((Weapon) equipment);
            }

            dataToView();
        });

        armorButton.addActionListener(e -> {
            equipment.setType(Equipment.ARMOR);
            typeLabel.setText(Equipment.ARMOR);

            if (equipment instanceof Weapon) {
                contentView.remove(weaponSubPanel);
                EquipmentFactory equipmentFactory = new EquipmentFactory();
                equipment = equipmentFactory.WeaponToEquipment((Weapon) equipment);
            }

            dataToView();
        });

        helmetButton.addActionListener(e -> {
            equipment.setType(Equipment.HELMET);
            typeLabel.setText(Equipment.HELMET);

            if (equipment instanceof Weapon) {
                contentView.remove(weaponSubPanel);
                EquipmentFactory equipmentFactory = new EquipmentFactory();
                equipment = equipmentFactory.WeaponToEquipment((Weapon) equipment);
            }

            dataToView();
        });

        ringButton.addActionListener(e -> {
            equipment.setType(Equipment.RING);
            typeLabel.setText(Equipment.RING);

            if (equipment instanceof Weapon) {
                contentView.remove(weaponSubPanel);
                EquipmentFactory equipmentFactory = new EquipmentFactory();
                equipment = equipmentFactory.WeaponToEquipment((Weapon) equipment);
            }

            dataToView();
        });

        beltButton.addActionListener(e -> {
            equipment.setType(Equipment.BELT);
            typeLabel.setText(Equipment.BELT);

            if (equipment instanceof Weapon) {
                contentView.remove(weaponSubPanel);
                EquipmentFactory equipmentFactory = new EquipmentFactory();
                equipment = equipmentFactory.WeaponToEquipment((Weapon) equipment);
            }

            dataToView();
        });

        bootsButton.addActionListener(e -> {
            equipment.setType(Equipment.BOOTS);
            typeLabel.setText(Equipment.BOOTS);

            if (equipment instanceof Weapon) {
                contentView.remove(weaponSubPanel);
                EquipmentFactory equipmentFactory = new EquipmentFactory();
                equipment = equipmentFactory.WeaponToEquipment((Weapon) equipment);
            }

            dataToView();
        });

        strButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ABILITY_STR);
            enhanceOnLabel.setText(Player.ABILITY_STR);
        });

        dexButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ABILITY_DEX);
            enhanceOnLabel.setText(Player.ABILITY_DEX);
        });

        conButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ABILITY_CON);
            enhanceOnLabel.setText(Player.ABILITY_CON);
        });

        intButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ABILITY_INT);
            enhanceOnLabel.setText(Player.ABILITY_INT);
        });

        wisButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ABILITY_WIS);
            enhanceOnLabel.setText(Player.ABILITY_WIS);
        });

        chaButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ABILITY_CHA);
            enhanceOnLabel.setText(Player.ABILITY_CHA);
        });

        armorClassButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ATTRIBUTE_ARMOR_CLASS);
            enhanceOnLabel.setText("AC");
        });

        attackBonusButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ATTRIBUTE_ATTACK_BONUS);
            enhanceOnLabel.setText("AB");
        });

        damageBonusButton.addActionListener(e -> {
            equipment.setEnhancedAttribute(Player.ATTRIBUTE_DAMAGE_BONUS);
            enhanceOnLabel.setText("DB");
        });

        valueSetButton.addActionListener(e -> {
            Integer enhancedValue = Integer.valueOf(valueTextField.getText());
            equipment.setEnhancedValue(enhancedValue);
        });

        validateButton.addActionListener(e -> {

            System.out.println(equipment);

            if(equipment.validate()){
                saveButton.setEnabled(true);
                validateResultLabel.setText("Success!");

            }else{
                saveButton.setEnabled(false);
                validateResultLabel.setText("Failure!");
            }

            ItemEditingScene.this.repaint();
        });

        meleeTypeButton.addActionListener(e -> {
            Weapon weapon = (Weapon) equipment;
            weapon.setWeaponType(Weapon.Type.MELEE);
            weaponTypeLabel.setText(Weapon.Type.MELEE.display());
        });

        rangedTypeButton.addActionListener(e -> {
            Weapon weapon = (Weapon) equipment;
            weapon.setWeaponType(Weapon.Type.RANGED);
            weaponTypeLabel.setText(Weapon.Type.RANGED.display());
        });

        rangeSetButton.addActionListener(e -> {
            Integer rangeValue = Integer.valueOf(rangeTextField.getText());
            ((Weapon)equipment).setRange(rangeValue);
            dataToView();
        });

        freezingButton.addActionListener(e -> {
            equipment = new WeaponDecoratorFreezing((Weapon) equipment);
            dataToView();
        });

        burningButton.addActionListener(e -> {
            equipment = new WeaponDecoratorBurning((Weapon) equipment);
            dataToView();
        });

        slayingButton.addActionListener(e -> {
            equipment = new WeaponDecoratorSlaying((Weapon) equipment);
            dataToView();
        });

        frighteningButton.addActionListener(e -> {
            equipment = new WeaponDecoratorFrightening((Weapon) equipment);
            dataToView();
        });

        pacifyingButton.addActionListener(e -> {
            equipment = new WeaponDecoratorPacifying((Weapon) equipment);
            dataToView();
        });

        resetButton.addActionListener(e -> {
            Weapon originalWeapon = ((Weapon) equipment).getOrigin();
            equipment = originalWeapon;
            dataToView();
        });

        repaint();
    }

    /**
     * This method is for saving purpose.
     */
    public void save(){
        EquipmentFileManager.save(equipment);
        navigationView.popTo(EditorScene.class);
    }

    /**
     * This method updates the view from the model.
     */
    public void dataToView(){

        typeLabel.setText(equipment.getType());
        enhanceOnLabel.setText(equipment.getEnhancedAttribute());
        valueTextField.setText(equipment.getEnhancedValue() + "");

        if (weaponSubPanelEnabeld) {

            Weapon weapon = (Weapon)equipment;

            nameLabel.setText(equipment.displayName());

            contentView.add(weaponSubPanel);
            weaponTypeLabel.setText(weapon.getWeaponType().display());
            rangeTextField.setText(weapon.getRange() + "");
            effectsValueLabel.setText(weapon.enchantmentsChainText());

        } else {
            nameLabel.setText(equipment.getName());
        }
    }


}


