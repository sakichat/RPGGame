package ui.controlView;

import game.Chest;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.1
 */
public class ChestControlView extends View {

    private Chest chest;

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public ChestControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    public void initSubviews() {

        JLabel jLabel;

        jLabel = new JLabel();
        jLabel.setSize(160, 40);
        jLabel.setLocation(10, 10);
        add(jLabel);
        jLabel.setText(MainControlView.CHEST);
        JLabel topicLabel = new JLabel();
        topicLabel = jLabel;

        jLabel = new JLabel();
        jLabel.setSize(160, 40);
        jLabel.setLocation(10, 60);
        add(jLabel);
        jLabel.setText(chest.getEquipment().getName());
        JLabel chestNameLabel = new JLabel();
        chestNameLabel = jLabel;

        JButton jButton;

        jButton = new JButton();
        jButton.setSize(160, 40);
        jButton.setLocation(10, 110);
        add(jButton);
        jButton.setText(MainControlView.REMOVE);
        JButton removeButton = new JButton();
        removeButton = jButton;

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
