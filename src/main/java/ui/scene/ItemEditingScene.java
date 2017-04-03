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

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 20);
        label.setText("Name");
        contentView.add(label);

        label = new JLabel();
        label.setSize(300, 40);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 20);
        nameLabel = label;
        contentView.add(label);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 70);
        label.setText("Type");
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 70);
        typeLabel = label;
        contentView.add(label);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 120);
        button.setText(Equipment.WEAPON);
        JButton weaponButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 120);
        button.setText(Equipment.SHIELD);
        JButton shieldButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 120);
        button.setText(Equipment.ARMOR);
        JButton armorButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 120);
        button.setText(Equipment.HELMET);
        JButton helmetButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 120);
        button.setText(Equipment.RING);
        JButton ringButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 120);
        button.setText(Equipment.BELT);
        JButton beltButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(810, 120);
        button.setText(Equipment.BOOTS);
        JButton bootsButton = button;
        contentView.add(button);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 170);
        label.setText("Enhance On");
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 170);
        enhanceOnLabel = label;
        contentView.add(label);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 220);
        button.setText(Player.ABILITY_STR);
        JButton strButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 220);
        button.setText(Player.ABILITY_DEX);
        JButton dexButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 220);
        button.setText(Player.ABILITY_CON);
        JButton conButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 220);
        button.setText(Player.ABILITY_INT);
        JButton intButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 220);
        button.setText(Player.ABILITY_WIS);
        JButton wisButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 220);
        button.setText(Player.ABILITY_CHA);
        JButton chaButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(150, 270);
        button.setText("Armor Class");
        JButton armorClassButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(370, 270);
        button.setText("Attack Bonus");
        JButton attackBonusButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(590, 270);
        button.setText("Damage Bonus");
        JButton damageBonusButton = button;
        contentView.add(button);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 320);
        label.setText("Value");
        contentView.add(label);

        textField = new TextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 320);
        valueTextField = textField;
        contentView.add(textField);

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(150, 370);
        button.setText("Validate");
        JButton validateButton = button;
        contentView.add(button);

        label = new JLabel();
        label.setSize(500, 40);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(350, 370);
        JLabel validateResultLabel = label;
        contentView.add(label);

        weaponSubPanel = new View();
        weaponSubPanel.setLayout(null);
        weaponSubPanel.setSize(960, 140);
        weaponSubPanel.setBackground(new Color(0xFFFFFF));
        weaponSubPanel.setLocation(20, 420);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(0, 0);
        label.setText("Range");
        weaponSubPanel.add(label);

        textField = new TextField();
        textField.setSize(160, 40);
        textField.setLocation(130, 0);
        rangeTextField = textField;
        weaponSubPanel.add(textField);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(300, 0);
        button.setText("Set");
        JButton rangeSetButton = button;
        weaponSubPanel.add(button);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(0, 50);
        label.setText("Enchantments");
        weaponSubPanel.add(label);

        label = new JLabel();
        label.setSize(540, 40);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(130, 50);
        enchantmentsValueLabel = label;
        weaponSubPanel.add(label);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(130, 100);
        button.setText("Freezing");
        JButton freezingButton = button;
        weaponSubPanel.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(240, 100);
        button.setText("Burning");
        JButton burningButton = button;
        weaponSubPanel.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(350, 100);
        button.setText("Slaying");
        JButton slayingButton = button;
        weaponSubPanel.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(460, 100);
        button.setText("Frightening");
        JButton frighteningButton = button;
        weaponSubPanel.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(570, 100);
        button.setText("Pacifying");
        JButton pacifyingButton = button;
        weaponSubPanel.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(790, 100);
        button.setText("RemoveAll");
        JButton removeAllButton = button;
        weaponSubPanel.add(button);

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

            WeaponDecorator decoratedWeapon = (WeaponDecorator) equipment;
            Weapon originalWeapon = (Weapon) decoratedWeapon.getOrigin();

            String enchantments = decoratedWeapon.getEnchantments();
            enchantmentsValueLabel.setText(enchantments);

            int range = originalWeapon.getRange();
            rangeTextField.setText(range + "");

        }

    }


}


