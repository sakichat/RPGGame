package ui.panel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import logic.Equipment;
import logic.Player;
import ui.view.EquipmentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * @author Kai QI
 * @version 0.2
 */
public class InventoryPanel extends Panel implements Observer {
    /**
     * The attribute player and Getter & Setter.
     */
    private Player player;

    /**
     * This method is the Player getter.
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This method is the Player setter.
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
        titleLabel.setText("Inventory - " + player.getName());
        dataToView();
        player.addObserver(this);
    }
    /**
     * The attribute buttonEnabled and getter&setter.
     */
    private boolean buttonEnabled;

    /**
     * Getter for buttonEnabled
     * @return
     */
    public boolean isButtonEnabled() {
        return buttonEnabled;
    }
    /**
     * Setter for buttonEnabled
     * @param buttonEnabled
     */
    public void setButtonEnabled(boolean buttonEnabled) {
        this.buttonEnabled = buttonEnabled;
        dataToView();
    }

    /**
     * property buttonText and Getter & Setter.
     */
    private String buttonText;

    /**
     * Getter for buttonText;
     * @return
     */
    public String getButtonText() {
        return buttonText;
    }

    /**
     * Setter for buttonText.
     * @param buttonText
     */
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    /**
     * Delegate
     */

    private InventoryDelegate inventoryDelegate;

    public InventoryDelegate getInventoryDelegate() {
        return inventoryDelegate;
    }

    public void setInventoryDelegate(InventoryDelegate inventoryDelegate) {
        this.inventoryDelegate = inventoryDelegate;
    }

    /**
     * Observer
     */

    /**
     * Override the update method.
     * Check if the data related to this panel are updated or not.
     * @param O Observable
     * @param x Object
     */
    @Override
    public void update(Observable O, Object x) {

        boolean change = false;
        change = change || x == Player.EQUIPMENT_CHANGE;
        change = change || x == Player.BACKPACK_CHANGE;

        if (change) {
            dataToView();
        }
    }
    /**
     * Constructor
     */
    @Override
    protected void init() {
        super.init();
        setSize(480, 540);
    }

    private EquipmentView weaponEquipmentView;
    private EquipmentView shieldEquipmentView;
    private EquipmentView armorEquipmentView;
    private EquipmentView helmetEquipmentView;
    private EquipmentView ringEquipmentView;
    private EquipmentView beltEquipmentView;
    private EquipmentView bootsEquipmentView;

    private JButton unequipWeaponBotton;
    private JButton unequipShieldBotton;
    private JButton unequipArmorBotton;
    private JButton unequipHelmetBotton;
    private JButton unequipRingBotton;
    private JButton unequipBeltBotton;
    private JButton unequipBootsBotton;

    private JPanel backpackSubPanel;

    /**
     * Layout
     */
    protected void initSubviews() {

        EquipmentView equipmentView;
        JButton button;
        JLabel label;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(30, 30);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.WEAPON);
        weaponEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(340, 30);
        unequipWeaponBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(30, 60);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.SHIELD);
        shieldEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(340, 60);
        unequipShieldBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(30, 90);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.ARMOR);
        armorEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(340, 90);
        unequipArmorBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(30, 120);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.HELMET);
        helmetEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(340, 120);
        unequipHelmetBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(30, 150);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.RING);
        ringEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(340, 150);
        unequipRingBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(30, 180);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.BELT);
        beltEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(340, 180);
        unequipBeltBotton = button;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(20, 20);
        label.setLocation(10, 210);
        add(label);
        label.setText("W");
        JLabel weaponLabel = label;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(30, 210);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.BOOTS);
        bootsEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(340, 210);
        unequipBootsBotton = button;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(20, 20);
        label.setLocation(10, 240);
        add(label);
        label.setText("B");
        JLabel backpackLabel = label;

        backpackSubPanel = new JPanel();
        backpackSubPanel.setLayout(null);
        backpackSubPanel.setSize(450, 310);
        backpackSubPanel.setLocation(30, 240);
        add(backpackSubPanel);

        unequipWeaponBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment currentEquipment = player.getEquipment(Equipment.WEAPON);
                if (currentEquipment != null) {
                    player.unequip(currentEquipment);
                }
            }
        });

        unequipShieldBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment currentEquipment = player.getEquipment(Equipment.SHIELD);
                if (currentEquipment != null) {
                    player.unequip(currentEquipment);
                }
            }
        });

        unequipArmorBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment currentEquipment = player.getEquipment(Equipment.ARMOR);
                if (currentEquipment != null) {
                    player.unequip(currentEquipment);
                }
            }
        });

        unequipHelmetBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment currentEquipment = player.getEquipment(Equipment.HELMET);
                if (currentEquipment != null) {
                    player.unequip(currentEquipment);
                }
            }
        });

        unequipRingBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment currentEquipment = player.getEquipment(Equipment.RING);
                if (currentEquipment != null) {
                    player.unequip(currentEquipment);
                }
            }
        });

        unequipBeltBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment currentEquipment = player.getEquipment(Equipment.BELT);
                if (currentEquipment != null) {
                    player.unequip(currentEquipment);
                }
            }
        });

        unequipBootsBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipment currentEquipment = player.getEquipment(Equipment.BOOTS);
                if (currentEquipment != null) {
                    player.unequip(currentEquipment);
                }
            }
        });
    }



    public void dataToView() {

        if (buttonEnabled) {
            add(unequipWeaponBotton);
            add(unequipShieldBotton);
            add(unequipArmorBotton);
            add(unequipHelmetBotton);
            add(unequipRingBotton);
            add(unequipBeltBotton);
            add(unequipBootsBotton);
        }

        Equipment weapon = player.getEquipment(Equipment.WEAPON);
        if (weapon != null) {
            weaponEquipmentView.setEquipment(weapon);
        } else {
            weaponEquipmentView.nameLabel.setText("");
            weaponEquipmentView.enhanceLabel.setText("");
        }

        Equipment shield = player.getEquipment(Equipment.SHIELD);
        if (shield != null) {
            shieldEquipmentView.setEquipment(shield);
        } else {
            shieldEquipmentView.nameLabel.setText("");
            shieldEquipmentView.enhanceLabel.setText("");
        }

        Equipment armor = player.getEquipment(Equipment.ARMOR);
        if (armor != null) {
            armorEquipmentView.setEquipment(armor);
        } else {
            armorEquipmentView.nameLabel.setText("");
            armorEquipmentView.enhanceLabel.setText("");
        }

        Equipment helmet = player.getEquipment(Equipment.HELMET);
        if (helmet != null) {
            helmetEquipmentView.setEquipment(helmet);
        } else {
            helmetEquipmentView.nameLabel.setText("");
            helmetEquipmentView.enhanceLabel.setText("");
        }

        Equipment ring = player.getEquipment(Equipment.RING);
        if (ring != null) {
            ringEquipmentView.setEquipment(ring);
        } else {
            ringEquipmentView.nameLabel.setText("");
            ringEquipmentView.enhanceLabel.setText("");
        }

        Equipment belt = player.getEquipment(Equipment.BELT);
        if (belt != null) {
            beltEquipmentView.setEquipment(belt);
        } else {
            beltEquipmentView.nameLabel.setText("");
            beltEquipmentView.enhanceLabel.setText("");
        }

        Equipment boots = player.getEquipment(Equipment.BOOTS);
        if (boots != null) {
            bootsEquipmentView.setEquipment(boots);
        } else {
            bootsEquipmentView.nameLabel.setText("");
            bootsEquipmentView.enhanceLabel.setText("");
        }

        backpackSubPanel.removeAll();
        int x = 0;
        int y = 0;

        List<Equipment> backpackContents = player.equipmentsInBackpack();

        for (Equipment equipment : backpackContents) {

            EquipmentView equipmentView = new EquipmentView();
            equipmentView.setLocation(x, y);
            backpackSubPanel.add(equipmentView);
            equipmentView.setEquipment(equipment);

            JButton equipButton = new JButton("equip");
            equipButton.setSize(60, 20);
            equipButton.setLocation(310, y);
            if (buttonEnabled) {
                backpackSubPanel.add(equipButton);
            }
            equipButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.equip(equipment);
                }
            });

            JButton operationButton = new JButton(buttonText);
            operationButton.setSize(60, 20);
            operationButton.setLocation(380, y);
            if (buttonEnabled) {
                backpackSubPanel.add(operationButton);
            }
            operationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (buttonText == "Drop") {
                        player.dropEquipment(equipment);
                    } else if (buttonText == "Exchange") {
//                        inventoryDelegate.inventoryExchangePerformAction(this, equipment);
                    }
                }
            });

            y += 30;
        }

        repaint();
    }
}
