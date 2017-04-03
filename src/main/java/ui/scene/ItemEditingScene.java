package ui.scene;

import logic.Equipment;
import logic.Player;
import logic.decorator.*;
import persistence.EquipmentFileManager;
import ui.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author GU_HAN
 * @version 0.2
 *
 * This scene is for editing the equipments.
 */
public class ItemEditingScene extends Scene {

    private Equipment equipment;

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
            equipment.setType(Equipment.WEAPON);
        }
        if(equipment.getEnhancedAttribute() == null){
            equipment.setEnhancedAttribute(Player.ABILITY_STR);
        }
        dataToView();
    }



    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel enhanceOnLabel;
    private TextField valueTextField;

    private JPanel weaponSubPanel;
    private TextField rangeTextField;
    private JLabel enchantmentsValueLabel;

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
        TextField textField;

        label = new JLabel("Name", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        label = new JLabel();
        label.setSize(300, 40);
        label.setLocation(150, 20);
        contentView.add(label);
        nameLabel = label;

        label = new JLabel("Type", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 70);
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setLocation(150, 70);
        contentView.add(label);
        typeLabel = label;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 120);
        button.setText(Equipment.WEAPON);
        contentView.add(button);
        JButton weaponButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 120);
        button.setText(Equipment.SHIELD);
        contentView.add(button);
        JButton shieldButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 120);
        button.setText(Equipment.ARMOR);
        contentView.add(button);
        JButton armorButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 120);
        button.setText(Equipment.HELMET);
        contentView.add(button);
        JButton helmetButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 120);
        button.setText(Equipment.RING);
        contentView.add(button);
        JButton ringButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 120);
        button.setText(Equipment.BELT);
        contentView.add(button);
        JButton beltButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(810, 120);
        button.setText(Equipment.BOOTS);
        JButton bootsButton = button;
        contentView.add(button);

        label = new JLabel("Enhance On", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 170);
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setLocation(150, 170);
        contentView.add(label);
        enhanceOnLabel = label;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 220);
        button.setText(Player.ABILITY_STR);
        contentView.add(button);
        JButton strButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 220);
        button.setText(Player.ABILITY_DEX);
        contentView.add(button);
        JButton dexButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 220);
        button.setText(Player.ABILITY_CON);
        contentView.add(button);
        JButton conButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 220);
        button.setText(Player.ABILITY_INT);
        contentView.add(button);
        JButton intButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 220);
        button.setText(Player.ABILITY_WIS);
        contentView.add(button);
        JButton wisButton = button;

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 220);
        button.setText(Player.ABILITY_CHA);
        contentView.add(button);
        JButton chaButton = button;

        button = new JButton("Armor Class");
        button.setSize(210, 40);
        button.setLocation(150, 270);
        contentView.add(button);
        JButton armorClassButton = button;

        button = new JButton("Attack Bonus");
        button.setSize(210, 40);
        button.setLocation(370, 270);
        contentView.add(button);
        JButton attackBonusButton = button;

        button = new JButton("Damage Bonus");
        button.setSize(210, 40);
        button.setLocation(590, 270);
        contentView.add(button);
        JButton damageBonusButton = button;

        label = new JLabel("Value", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(20, 320);
        contentView.add(label);

        textField = new TextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 320);
        contentView.add(textField);
        valueTextField = textField;

        button = new JButton("Validate");
        button.setSize(160, 40);
        button.setLocation(150, 370);
        contentView.add(button);
        JButton validateButton = button;

        label = new JLabel();
        label.setSize(500, 40);
        label.setLocation(350, 370);
        contentView.add(label);
        JLabel validateResultLabel = label;

        weaponSubPanel = new View();
        weaponSubPanel.setSize(960, 140);
        weaponSubPanel.setLocation(20, 420);
        weaponSubPanel.setBackground(new Color(0xFFFFFF));

        label = new JLabel("Range", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(0, 0);
        weaponSubPanel.add(label);

        textField = new TextField();
        textField.setSize(160, 40);
        textField.setLocation(130, 0);
        weaponSubPanel.add(textField);
        rangeTextField = textField;

        button = new JButton("Set");
        button.setSize(100, 40);
        button.setLocation(300, 0);
        weaponSubPanel.add(button);
        JButton rangeSetButton = button;

        label = new JLabel("Enchantments", JLabel.RIGHT);
        label.setSize(120, 40);
        label.setLocation(0, 50);
        weaponSubPanel.add(label);

        label = new JLabel();
        label.setSize(540, 40);
        label.setLocation(130, 50);
        weaponSubPanel.add(label);
        enchantmentsValueLabel = label;

        button = new JButton("Freezing");
        button.setSize(100, 40);
        button.setLocation(130, 100);
        weaponSubPanel.add(button);
        JButton freezingButton = button;

        button = new JButton("Burning");
        button.setSize(100, 40);
        button.setLocation(240, 100);
        weaponSubPanel.add(button);
        JButton burningButton = button;

        button = new JButton("Slaying");
        button.setSize(100, 40);
        button.setLocation(350, 100);
        weaponSubPanel.add(button);
        JButton slayingButton = button;

        button = new JButton("Frightening");
        button.setSize(100, 40);
        button.setLocation(460, 100);
        weaponSubPanel.add(button);
        JButton frighteningButton = button;

        button = new JButton("Pacifying");
        button.setSize(100, 40);
        button.setLocation(570, 100);
        weaponSubPanel.add(button);
        JButton pacifyingButton = button;

        button = new JButton("Remove All");
        button.setSize(100, 40);
        button.setLocation(790, 100);
        weaponSubPanel.add(button);
        JButton removeAllButton = button;

        /*
         * add Listener
         */
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        weaponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.WEAPON);
                typeLabel.setText(Equipment.WEAPON);
            }
        });

        shieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.SHIELD);
                typeLabel.setText(Equipment.SHIELD);
            }
        });

        armorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.ARMOR);
                typeLabel.setText(Equipment.ARMOR);
            }
        });

        helmetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.HELMET);
                typeLabel.setText(Equipment.HELMET);

            }
        });

        ringButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.RING);
                typeLabel.setText(Equipment.RING);
            }
        });

        beltButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.BELT);
                typeLabel.setText(Equipment.BELT);
            }
        });

        bootsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.BOOTS);
                typeLabel.setText(Equipment.BOOTS);
            }
        });

        strButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_STR);
                enhanceOnLabel.setText(Player.ABILITY_STR);
            }
        });

        dexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_DEX);
                enhanceOnLabel.setText(Player.ABILITY_DEX);
            }
        });

        conButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_CON);
                enhanceOnLabel.setText(Player.ABILITY_CON);
            }
        });

        intButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_INT);
                enhanceOnLabel.setText(Player.ABILITY_INT);
            }
        });

        wisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_WIS);
                enhanceOnLabel.setText(Player.ABILITY_WIS);
            }
        });

        chaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_CHA);
                enhanceOnLabel.setText(Player.ABILITY_CHA);
            }
        });

        armorClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ATTRIBUTE_ARMOR_CLASS);
                enhanceOnLabel.setText("Armor Class");
            }
        });

        attackBonusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ATTRIBUTE_ATTACK_BONUS);
                enhanceOnLabel.setText("Attack Bonus");
            }
        });

        damageBonusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ATTRIBUTE_DAMAGE_BONUS);
                enhanceOnLabel.setText("Damage Bonus");
            }
        });

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedValue(Integer.valueOf(valueTextField.getText()));

                System.out.println(equipment);

                if(equipment.validate()){

                    saveButton.setEnabled(true);

                    if (equipment.getType().equals(Equipment.WEAPON)) {

                        validateResultLabel.setText("Success!  Please set Range and Special Enchantments for the weapon.");
                        contentView.add(weaponSubPanel);

                        Weapon weapon = equipment.toWeapon();
                        equipment = weapon;

                    } else {
                        validateResultLabel.setText("Success!");
                    }
                }else{
                    saveButton.setEnabled(false);
                    validateResultLabel.setText("Failure!");
                }

                ItemEditingScene.this.repaint();
            }
        });

        rangeSetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Weapon weapon = (Weapon) equipment;
                Integer range = Integer.valueOf(rangeTextField.getText());
                weapon.setRange(range);
                dataToView();
            }
        });

        freezingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment = new FreezingDecorator((DecoratorComponent) equipment);
                dataToView();
            }
        });

        burningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment = new BurningDecorator((DecoratorComponent) equipment);
                dataToView();
            }
        });

        slayingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment = new SlayingDecorator((DecoratorComponent) equipment);
                dataToView();
            }
        });

        frighteningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment = new FrighteningDecorator((DecoratorComponent) equipment);
                dataToView();
            }
        });

        pacifyingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment = new PacifyingDecorator((DecoratorComponent) equipment);
                dataToView();
            }
        });

        removeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
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

        nameLabel.setText(equipment.getName());
        typeLabel.setText(equipment.getType());
        enhanceOnLabel.setText(equipment.getEnhancedAttribute());
        valueTextField.setText(equipment.getEnhancedValue() + "");

        if (equipment instanceof Weapon) {
            Weapon weapon = (Weapon) this.equipment;

            int range = weapon.getRange();
            rangeTextField.setText(range + "");

            String enchantments = (weapon.getEnchantments());
            rangeTextField.setText(enchantments);

        } else if (equipment instanceof WeaponDecorator){
            WeaponDecorator decoratedWeapon = (WeaponDecorator) equipment;
            Weapon originalWeapon = (Weapon) decoratedWeapon.getOrigin();

            int range = originalWeapon.getRange();
            rangeTextField.setText(range + "");

            String enchantments = decoratedWeapon.getEnchantments();
            enchantmentsValueLabel.setText(enchantments);

        }

    }


}


