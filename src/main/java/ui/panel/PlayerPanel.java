package ui.panel;

import logic.Player;
import ui.view.AbilityView;
import ui.view.TextDisplay;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Kai QI
 * @version 0.2
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
        titleLabel.setText(player.getPlayerParty() + " - " + player.getName());

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
        change = change || x == Player.PLAYER_TYPE_CHANGE;
        change = change || x == Player.PLAYER_PARTY_CHANGE;
        change = change || x == Player.ABILITY_CHANGE;
        change = change || x == Player.HP_CHANGE;

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

        setSize(360, 240);
    }

    private JLabel nameValueLabel;
    private JLabel levelValueLabel;
    private JLabel playerTypeValueLabel;
    private JLabel playerPartyValueLabel;

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

    /**
     * Layout
     */
    protected void initSubviews(){

        JLabel label;
        AbilityView abilityView;

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

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(60, 20);
        label.setLocation(10, 60);
        add(label);
        label.setText("Type");
        JLabel playerTypeLabel = label;

        label = new JLabel();
        label.setSize(90, 20);
        label.setLocation(80, 60);
        add(label);
        playerTypeValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(60, 20);
        label.setLocation(190, 60);
        add(label);
        label.setText("Party");
        JLabel playerPartyLabel = label;

        label = new JLabel();
        label.setSize(90, 20);
        label.setLocation(260, 60);
        add(label);
        playerPartyValueLabel = label;


        abilityView = new AbilityView();
        abilityView.setLocation(10, 90);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_STR);
        strAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(190, 90);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_INT);
        intAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(10, 120);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_DEX);
        dexAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(190, 120);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_WIS);
        wisAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(10, 150);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_CON);
        conAbilityView = abilityView;

        abilityView = new AbilityView();
        abilityView.setLocation(190, 150);
        add(abilityView);
        abilityView.nameLabel.setText(Player.ABILITY_CHA);
        chaAbilityView = abilityView;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(10, 180);
        add(label);
        label.setText("Hit Point");
        JLabel hpLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(120, 180);
        add(label);
        hpValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(190, 180);
        add(label);
        label.setText("Attack Bonus");
        JLabel abLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(300, 180);
        add(label);
        abValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(10, 210);
        add(label);
        label.setText("Armor Class");
        JLabel acLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(120, 210);
        add(label);
        acValueLabel = label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(100, 20);
        label.setLocation(190, 210);
        add(label);
        label.setText("Damage Bonus");
        JLabel dbLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(300, 210);
        add(label);
        dbValueLabel = label;

    }

    /**
     * This is a method makes data transfer to view
     */
    public void dataToView() {

        nameValueLabel.setText(player.getName());
        levelValueLabel.setText(player.getLevel() + "");
        playerTypeValueLabel.setText(player.getPlayerType());
        playerPartyValueLabel.setText(player.getPlayerParty());

        strAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_STR) + "");
        Integer totalAbilityModifierSTR = player.getTotalAbilityModifier(Player.ABILITY_STR);
        strAbilityView.modifierLabel.setText(TextDisplay.signedNumber(totalAbilityModifierSTR));

        intAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_INT) + "");
        Integer totalAbilityModifierINT = player.getTotalAbilityModifier(Player.ABILITY_INT);
        intAbilityView.modifierLabel.setText(TextDisplay.signedNumber(totalAbilityModifierINT));

        dexAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_DEX) + "");
        Integer totalAbilityModifierDEX = player.getTotalAbilityModifier(Player.ABILITY_DEX);
        dexAbilityView.modifierLabel.setText(TextDisplay.signedNumber(totalAbilityModifierDEX));

        wisAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_WIS) + "");
        Integer totalAbilityModifierWIS = player.getTotalAbilityModifier(Player.ABILITY_WIS);
        wisAbilityView.modifierLabel.setText(TextDisplay.signedNumber(totalAbilityModifierWIS));

        conAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_CON) + "");
        Integer totalAbilityModifierCON = player.getTotalAbilityModifier(Player.ABILITY_CON);
        conAbilityView.modifierLabel.setText(TextDisplay.signedNumber(totalAbilityModifierCON));

        chaAbilityView.scoreLabel.setText(player.getTotalAbilityScore(Player.ABILITY_CHA) + "");
        Integer totalAbilityModifierCHA = player.getTotalAbilityModifier(Player.ABILITY_CHA);
        chaAbilityView.modifierLabel.setText(TextDisplay.signedNumber(totalAbilityModifierCHA));

        hpValueLabel.setText(player.getHp() + "");
        abValueLabel.setText(player.getTotalAttackBonus() + "");
        acValueLabel.setText(player.getTotalArmorClass() + "");
        dbValueLabel.setText(player.getTotalDamageBonus() + "");

        repaint();

    }

    
}
