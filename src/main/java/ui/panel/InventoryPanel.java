package ui.panel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import logic.Equipment;
import logic.Player;
import ui.view.EquipmentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

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
        dataToView();
        player.addObserver(this);
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

    private EquipmentView weaponEquipmentView;
    private EquipmentView shieldEquipmentView;
    private EquipmentView armorEquipmentView;
    private EquipmentView helmetEquipmentView;
    private EquipmentView ringEquipmentView;
    private EquipmentView beltEquipmentView;
    private EquipmentView bootsEquipmentView;

    private JButton unequipWeaponBotton;
    private Boolean unequipWeaponBottonEnabled;
    private JButton unequipShieldBotton;
    private Boolean unequipShieldBottonEnabled;
    private JButton unequipArmorBotton;
    private Boolean unequipArmorBottonEnabled;
    private JButton unequipHelmetBotton;
    private Boolean unequipHelmetBottonEnabled;
    private JButton unequipRingBotton;
    private Boolean unequipRingBottonEnabled;
    private JButton unequipBeltBotton;
    private Boolean unequipBeltBottonEnabled;
    private JButton unequipBootsBotton;
    private Boolean unequipBootsBottonEnabled;

    /**
     * Getter & setter for all the buttonEnabled boolean properties.
     * @return
     */

    /**
     * Getter for unequipWeaponBottonEnabled;
     * @return
     */
    public Boolean getUnequipWeaponBottonEnabled() {
        return unequipWeaponBottonEnabled;
    }

    /**
     * Setter for unequipWeaponBottonEnabled;
     * @param unequipWeaponBottonEnabled
     */
    public void setUnequipWeaponBottonEnabled(Boolean unequipWeaponBottonEnabled) {
        this.unequipWeaponBottonEnabled = unequipWeaponBottonEnabled;
    }

    /**
     * Getter for unequipShieldBottonEnabled;
     * @return
     */
    public Boolean getUnequipShieldBottonEnabled() {
        return unequipShieldBottonEnabled;
    }

    /**
     * Setter for unequipShieldBottonEnabled;
     * @param unequipShieldBottonEnabled
     */
    public void setUnequipShieldBottonEnabled(Boolean unequipShieldBottonEnabled) {
        this.unequipShieldBottonEnabled = unequipShieldBottonEnabled;
    }

    /**
     * Getter for unequipArmorBottonEnabled;
     * @return
     */
    public Boolean getUnequipArmorBottonEnabled() {
        return unequipArmorBottonEnabled;
    }

    /**
     * Setter for unequipArmorBottonEnabled;
     * @param unequipArmorBottonEnabled
     */
    public void setUnequipArmorBottonEnabled(Boolean unequipArmorBottonEnabled) {
        this.unequipArmorBottonEnabled = unequipArmorBottonEnabled;
    }

    /**
     * Getter for unequipHelmetBottonEnabled;
     * @return
     */
    public Boolean getUnequipHelmetBottonEnabled() {
        return unequipHelmetBottonEnabled;
    }

    /**
     * Setter for unequipHelmetBottonEnabled;
     * @param unequipHelmetBottonEnabled
     */
    public void setUnequipHelmetBottonEnabled(Boolean unequipHelmetBottonEnabled) {
        this.unequipHelmetBottonEnabled = unequipHelmetBottonEnabled;
    }

    /**
     * Getter for unequipRingBottonEnabled;
     * @return
     */
    public Boolean getUnequipRingBottonEnabled() {
        return unequipRingBottonEnabled;
    }

    /**
     * Setter for unequipRingBottonEnabled;
     * @param unequipRingBottonEnabled
     */
    public void setUnequipRingBottonEnabled(Boolean unequipRingBottonEnabled) {
        this.unequipRingBottonEnabled = unequipRingBottonEnabled;
    }

    /**
     * Getter for unequipBeltBottonEnabled;
     * @return
     */
    public Boolean getUnequipBeltBottonEnabled() {
        return unequipBeltBottonEnabled;
    }

    /**
     * Setter for unequipBeltBottonEnabled;
     * @param unequipBeltBottonEnabled
     */
    public void setUnequipBeltBottonEnabled(Boolean unequipBeltBottonEnabled) {
        this.unequipBeltBottonEnabled = unequipBeltBottonEnabled;
    }

    /**
     * Getter for unequipBootsBottonEnabled;
     * @return
     */
    public Boolean getUnequipBootsBottonEnabled() {
        return unequipBootsBottonEnabled;
    }

    /**
     * Setter for unequipBootsBottonEnabled;
     * @param unequipBootsBottonEnabled
     */
    public void setUnequipBootsBottonEnabled(Boolean unequipBootsBottonEnabled) {
        this.unequipBootsBottonEnabled = unequipBootsBottonEnabled;
    }

    /**
     * Layout
     */
    protected void initSubviews() {

        EquipmentView equipmentView;
        JButton button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 210);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.WEAPON);
        weaponEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 210);
        add(button);
        unequipWeaponBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 240);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.SHIELD);
        shieldEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 240);
        add(button);
        unequipShieldBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 270);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.ARMOR);
        armorEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 270);
        add(button);
        unequipArmorBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 300);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.HELMET);
        helmetEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 300);
        add(button);
        unequipHelmetBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 330);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.RING);
        ringEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 330);
        add(button);
        unequipRingBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 360);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.BELT);
        beltEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 360);
        add(button);
        unequipBeltBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 390);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.BOOTS);
        bootsEquipmentView = equipmentView;

        button = new JButton("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 390);
        add(button);
        unequipBootsBotton = button;

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

        repaint();
    }
}
