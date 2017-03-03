package ui.panel;

import logic.Equipment;
import logic.Player;
import ui.view.AbilityView;
import ui.view.EquipmentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Kai QI
 * @version 0.1
 *
 * This class if for PlayerPanel.
 */
public class PlayerPanel extends Panel implements Observer {

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
        change = change || x == Player.LEVEL_CHANGE;
        change = change || x == Player.ABILITY_CHANGE;
        change = change || x == Player.HP_CHANGE;
        change = change || x == Player.EQUIPMENT_CHANGE;

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

        setSize(400, 420);
        title = "Player";
    }

    private JLabel nameValueLabel;
    private JLabel levelValueLabel;

    private AbilityView strAbilityView;
    private AbilityView intAbilityView;
    private AbilityView dexAbilityView;
    private AbilityView wisAbilityView;
    private AbilityView conAbilityView;
    private AbilityView chaAbilityView;

    private JLabel hpValueLabel;
    private JLabel abValueLabel;
    private JLabel acValueLabel;
    private JLabel dbValueLabel;

    private EquipmentView weaponEquipmentView;
    private EquipmentView shieldEquipmentView;
    private EquipmentView armorEquipmentView;
    private EquipmentView helmetEquipmentView;
    private EquipmentView ringEquipmentView;
    private EquipmentView beltEquipmentView;
    private EquipmentView bootsEquipmentView;

    Button unequipWeaponBotton;
    Button unequipShieldBotton;
    Button unequipArmorBotton;
    Button unequipHelmetBotton;
    Button unequipRingBotton;
    Button unequipBeltBotton;
    Button unequipBootsBotton;

    /**
     * Layout
     */
    protected void initSubviews(){

        JLabel label;
        AbilityView abilityView;
        EquipmentView equipmentView;
        Button button;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(60, 20);
        label.setLocation(10, 30);
        add(label);
        label.setText("Name");
        JLabel nameLabel = label;

        label = new JLabel();
        label.setSize(90, 20);
        label.setLocation(80, 30);
        add(label);
        nameValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(60, 20);
        label.setLocation(190, 30);
        add(label);
        label.setText("Level");
        JLabel levelLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(260, 30);
        add(label);
        levelValueLabel = label;

        abilityView = new AbilityView();
        abilityView.setLocation(10, 60);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_STR);
        strAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(190, 60);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_INT);
        intAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(10, 90);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_DEX);
        dexAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(190, 90);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_WIS);
        wisAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(10, 120);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_CON);
        conAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(190, 120);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_CHA);
        chaAbilityView = abilityView;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(10, 150);
        add(label);
        label.setText("Hit Point");
        JLabel hpLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(120, 150);
        add(label);
        hpValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(190, 150);
        add(label);
        label.setText("Attack Bonus");
        JLabel abLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(300, 150);
        add(label);
        abValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(10, 180);
        add(label);
        label.setText("Armor Class");
        JLabel acLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(120, 180);
        add(label);
        acValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(190, 180);
        add(label);
        label.setText("Damage Bonus");
        JLabel dbLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(300, 180);
        add(label);
        dbValueLabel = label;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 210);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.WEAPON);
        weaponEquipmentView = equipmentView;

        button = new Button("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 210);
        add(button);
        unequipWeaponBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 240);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.SHIELD);
        shieldEquipmentView = equipmentView;

        button = new Button("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 240);
        add(button);
        unequipShieldBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 270);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.ARMOR);
        armorEquipmentView = equipmentView;

        button = new Button("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 270);
        add(button);
        unequipArmorBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 300);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.HELMET);
        helmetEquipmentView = equipmentView;

        button = new Button("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 300);
        add(button);
        unequipHelmetBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 330);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.RING);
        ringEquipmentView = equipmentView;

        button = new Button("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 330);
        add(button);
        unequipRingBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 360);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.BELT);
        beltEquipmentView = equipmentView;

        button = new Button("unequip");
        button.setSize(60, 20);
        button.setLocation(320, 360);
        add(button);
        unequipBeltBotton = button;

        equipmentView = new EquipmentView();
        equipmentView.setLocation(10, 390);
        add(equipmentView);
        equipmentView.typeLabel.setText(Equipment.BOOTS);
        bootsEquipmentView = equipmentView;

        button = new Button("unequip");
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

    /**
     * This is a method makes data transfer to view
     */
    public void dataToView() {

        nameValueLabel.setText(player.getName());
        levelValueLabel.setText(player.getLevel() + "");

        strAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_STR) + "");
        strAbilityView.modifierLabel.setText(player.getTotalAbilityModifier(Player.ABILITY_STR) + "");

        intAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_INT) + "");
        intAbilityView.modifierLabel.setText(player.getTotalAbilityModifier(Player.ABILITY_INT) + "");

        dexAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_DEX) + "");
        dexAbilityView.modifierLabel.setText(player.getTotalAbilityModifier(Player.ABILITY_DEX) + "");

        wisAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_WIS) + "");
        wisAbilityView.modifierLabel.setText(player.getTotalAbilityModifier(Player.ABILITY_WIS) + "");

        conAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_CON) + "");
        conAbilityView.modifierLabel.setText(player.getTotalAbilityModifier(Player.ABILITY_CON) + "");

        chaAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_CHA) + "");
        chaAbilityView.modifierLabel.setText(player.getTotalAbilityModifier(Player.ABILITY_CHA) + "");

        hpValueLabel.setText(player.getHp() + "");
        abValueLabel.setText(player.getTotalAttackBonus() + "");
        acValueLabel.setText(player.getTotalArmorClass() + "");
        dbValueLabel.setText(player.getTotalDamageBonus() + "");

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
