package ui.scene;

import game.Equipment;
import game.Player;
import persistence.EquipmentFileManager;
import ui.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author GU_HAN
 * @version 1.0.1
 */
public class ItemEditingScene extends Scene {
    private Equipment equipment;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }



    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel enhanceOnLabel;
    private TextField valueTextField;

    private JButton weaponButton;
    private JButton shieldButton;
    private JButton armorButton;
    private JButton helmetButton;
    private JButton ringButton;
    private JButton beltButton;
    private JButton bootsButton;

    private JButton strButton;
    private JButton dexButton;
    private JButton conButton;
    private JButton intButton;
    private JButton wisButton;
    private JButton chaButton;
    private JButton armorClassButton;
    private JButton attackBonusButton;
    private JButton damageBonusButton;

    private JButton validateButton;

    @Override
    protected void init() {
        super.init();
        
        titleName = "Edit Item";
        backButton = true;
        saveButton = true;
    }

    protected void initSubviews(){

        /*
         * First Line
         */

        JLabel label;
        JButton button;
        TextField textField;

        /*
         * 4 Stable Label
         */

        label = new JLabel();
        label.setSize(120, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 60);
        label.setText("Name");
        this.add(label);

        label = new JLabel();
        label.setSize(120, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 110);
        label.setText("Type");
        this.add(label);

        label = new JLabel();
        label.setSize(120, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 210);
        label.setText("Enhance On");
        this.add(label);

        label = new JLabel();
        label.setSize(120, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 360);
        label.setText("Value");
        this.add(label);

        /*
         * 3 Dynamic Outprint
         */

        label = new JLabel();
        label.setSize(200, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 60);
        nameLabel = label;
        this.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 110);
        typeLabel = label;
        this.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 210);
        enhanceOnLabel = label;
        this.add(label);

        /*
         * 7 Choices of Type
         */

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 160);
        button.setText("Weapon");
        weaponButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 160);
        button.setText("Shield");
        shieldButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 160);
        button.setText("Armor");
        armorButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 160);
        button.setText("Helmet");
        helmetButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 160);
        button.setText("Ring");
        ringButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 160);
        button.setText("Belt");
        beltButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(810, 160);
        button.setText("Boots");
        bootsButton = button;
        add(button);

        /*
         * 6 Choices of Enhance on
         */

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 260);
        button.setText("Str");
        strButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 260);
        button.setText("Dex");
        dexButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 260);
        button.setText("Con");
        conButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 260);
        button.setText("Int");
        intButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 260);
        button.setText("Wis");
        wisButton = button;
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 260);
        button.setText("Cha");
        chaButton = button;
        add(button);

        /*
         * 3 Value of Choose
         */

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(150, 310);
        button.setText("Armor Class");
        armorClassButton = button;
        add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(370, 310);
        button.setText("Attack Bonus");
        attackBonusButton = button;
        add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(590, 310);
        button.setText("Damage Bonus");
        damageBonusButton = button;
        add(button);

        /*
         * TextFile
         */

        textField = new TextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 360);
        valueTextField = textField;
        this.add(textField);

        /*
         * Validate button
         */

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(150, 440);
        button.setText("Validate");
        validateButton = button;
        add(button);

        /*
         * add Listener
         */
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemEditingScene.this.viewFlow.pop();
            }
        });

        save.addActionListener(new ActionListener() {
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
                equipment.setType(Player.ABILITY_STR);
                enhanceOnLabel.setText("Str");
            }
        });

        dexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Player.ABILITY_DEX);
                enhanceOnLabel.setText("Dex");
            }
        });

        conButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Player.ABILITY_CON);
                enhanceOnLabel.setText("Con");
            }
        });

        intButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Player.ABILITY_INT);
                enhanceOnLabel.setText("Int");
            }
        });

        wisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Player.ABILITY_WIS);
                enhanceOnLabel.setText("Wis");
            }
        });

        chaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Player.ABILITY_CHA);
                enhanceOnLabel.setText("Cha");
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
                enhanceOnLabel.setText("Attck Bonus");
            }
        });

        damageBonusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ATTRIBUTE_DAMAGE_BONUS);
                enhanceOnLabel.setText("Damage Bonus");
            }
        });

        valueTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedValue(Integer.valueOf(valueTextField.getText()));
            }
        });

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(equipment.validate()){
                    save.setEnabled(true);
                }else{
                    save.setEnabled(false);
                }
            }
        });

        repaint();
    }

    public void save(){
        EquipmentFileManager.save(equipment);
        viewFlow.pop();
    }

    public void dataToView(){
        nameLabel.setText(equipment.getName());
        typeLabel.setText(equipment.getType());
        enhanceOnLabel.setText(equipment.getEnhancedAttribute());
        valueTextField.setText(equipment.getEnhancedValue() + "");

    }


}


