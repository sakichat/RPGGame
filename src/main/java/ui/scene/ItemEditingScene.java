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
        saveButton.setEnabled(false);
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
        label.setLocation(20, 20);
        label.setText("Name");
        contentView.add(label);

        label = new JLabel();
        label.setSize(200, 40);
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
        weaponButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 120);
        button.setText(Equipment.SHIELD);
        shieldButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 120);
        button.setText(Equipment.ARMOR);
        armorButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 120);
        button.setText(Equipment.HELMET);
        helmetButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 120);
        button.setText(Equipment.RING);
        ringButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 120);
        button.setText(Equipment.BELT);
        beltButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(810, 120);
        button.setText(Equipment.BOOTS);
        bootsButton = button;
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
        strButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(260, 220);
        button.setText(Player.ABILITY_DEX);
        dexButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(370, 220);
        button.setText(Player.ABILITY_CON);
        conButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(480, 220);
        button.setText(Player.ABILITY_INT);
        intButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(590, 220);
        button.setText(Player.ABILITY_WIS);
        wisButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(100, 40);
        button.setLocation(700, 220);
        button.setText(Player.ABILITY_CHA);
        chaButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(150, 270);
        button.setText("Armor Class");
        armorClassButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(370, 270);
        button.setText("Attack Bonus");
        attackBonusButton = button;
        contentView.add(button);

        button = new JButton();
        button.setSize(210, 40);
        button.setLocation(590, 270);
        button.setText("Damage Bonus");
        damageBonusButton = button;
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
        validateButton = button;
        contentView.add(button);

        label = new JLabel();
        label.setSize(200, 40);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setLocation(350, 370);
        validateResultLabel = label;
        contentView.add(label);



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


