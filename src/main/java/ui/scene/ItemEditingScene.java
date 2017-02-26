package ui.scene;

import game.Equipment;
import game.Player;
import ui.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by GU_HAN on 2017-02-26.
 * @author GU_HAN
 */
public class ItemEditingScene extends View {
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
    private JButton saveButton;

    public ItemEditingScene() {
        setLayout(null);
        setSize(1000, 600);

        initSubviews();
    }

    private void initSubviews(){

        /*
         * First Line
         */

        JLabel label;
        JButton button;
        TextField textField;

        label = new JLabel();
        label.setSize(1000, 40);
        label.setLocation(0, 0);
        label.setText("Edit Item");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBackground(new Color(0x92A99C));
        label.setOpaque(true);
        this.add(label);

        button = new JButton();
        button.setSize(60, 20);
        button.setLocation(10, 10);
        button.setText("Back");
        label.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemEditingScene.this.viewFlow.pop();
            }
        });

        button = new JButton();
        button.setSize(60, 20);
        button.setLocation(930, 10);
        button.setText("Save");
        button.setEnabled(false);
        saveButton = button;
        label.add(button);

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
        label.setLocation(20, 410);
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
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.WEAPON);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 160);
        button.setText("Shield");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.SHIELD);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 160);
        button.setText("Armor");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.ARMOR);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 160);
        button.setText("Helmet");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.HELMET);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 160);
        button.setText("Ring");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.RING);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 160);
        button.setText("Belt");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.BELT);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(810, 160);
        button.setText("Boots");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setType(Equipment.BOOTS);
            }
        });
        add(button);

        /*
         * 7 Choices of Enhance on
         */

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 260);
        button.setText("None");

        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(150, 310);
        button.setText("Str");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_STR);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 310);
        button.setText("Dex");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_DEX);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 310);
        button.setText("Con");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_CON);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 310);
        button.setText("Int");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_INT);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 310);
        button.setText("Wis");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_WIS);
            }
        });
        add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 310);
        button.setText("Cha");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_CHA);
            }
        });
        add(button);

        /*
         * 3 Value of Choose
         */

        label = new JLabel();
        label.setSize(210, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setLocation(150, 360);
        label.setText("Armor Class");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ATTRIBUTE_ARMOR_CLASS);
            }
        });
        this.add(label);

        label = new JLabel();
        label.setSize(210, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setLocation(370, 360);
        label.setText("Attack Bonus");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ATTRIBUTE_ATTACK_BONUS);
            }
        });
        this.add(label);

        label = new JLabel();
        label.setSize(210, 40);
        label.setOpaque(true);
        label.setBackground(new Color(0xAED6F1));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setLocation(590, 360);
        label.setText("Damage Bonus");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ATTRIBUTE_DAMAGE_BONUS);
            }
        });
        this.add(label);

        /*
         * TextFile
         */

        textField = new TextField();
        textField.setSize(160, 40);
        textField.setLocation(150, 410);
        valueTextField = textField;
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedValue(Integer.valueOf(textField.getText()));
            }
        });
        this.add(textField);

        /*
         * Validate button
         */

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(150, 490);
        button.setText("Validate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(equipment.validate()){
                    saveButton.setEnabled(true);
                }else{
                    saveButton.setEnabled(false);
                }
            }
        });
        add(button);

        repaint();
    }

    public void dataToView(){
        nameLabel.setText(equipment.getName());
        typeLabel.setText(equipment.getType());
        enhanceOnLabel.setText(equipment.getEnhancedAttribute());

    }

}


