package ui.scene;

import logic.Equipment;
import logic.Player;
import persistence.EquipmentFileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author GU_HAN
 * @version 0.1
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
//        if(equipment.getEnhancedValue() == 0){
//            equipment.setEnhancedValue(1);
//        }
        dataToView();
    }



    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel enhanceOnLabel;
    private TextField valueTextField;

    private JLabel validateResultLabel;

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
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 60);
        label.setText("Name");
        this.add(label);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 110);
        label.setText("Type");
        this.add(label);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 210);
        label.setText("Enhance On");
        this.add(label);

        label = new JLabel();
        label.setSize(120, 40);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setLocation(20, 360);
        label.setText("Value");
        this.add(label);

        /*
         * 3 Dynamic Outprint
         */

        label = new JLabel();
        label.setSize(200, 40);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 60);
        nameLabel = label;
        this.add(label);

        label = new JLabel();
        label.setSize(200, 40);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setLocation(150, 110);
        typeLabel = label;
        this.add(label);

        label = new JLabel();
        label.setSize(200, 40);
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

        label = new JLabel();
        label.setSize(200, 40);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setLocation(350, 440);
        validateResultLabel = label;
        add(label);


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
                ItemEditingScene.this.navigationView.popTo(EditorScene.class);
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
                enhanceOnLabel.setText("Str");
            }
        });

        dexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_DEX);
                enhanceOnLabel.setText("Dex");
            }
        });

        conButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_CON);
                enhanceOnLabel.setText("Con");
            }
        });

        intButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_INT);
                enhanceOnLabel.setText("Int");
            }
        });

        wisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_WIS);
                enhanceOnLabel.setText("Wis");
            }
        });

        chaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedAttribute(Player.ABILITY_CHA);
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

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment.setEnhancedValue(Integer.valueOf(textField.getText()));

                System.out.println(equipment);

                if(equipment.validate()){
                    saveButton.setEnabled(true);
                    validateResultLabel.setText("Success!");
                }else{
                    saveButton.setEnabled(false);
                    validateResultLabel.setText("Failure!");
                }

                ItemEditingScene.this.repaint();
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

    }


}


