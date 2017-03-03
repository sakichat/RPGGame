package ui.controlView;

import logic.Chest;
import ui.scene.MapEditingScene;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.1
 */
public class ChestControlView extends ControlView {

    private Chest chest;
    private JLabel chestNameLabel;

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
        dataToView();
    }

    public ChestControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    public void initSubviews() {

        JLabel label;

        label = new JLabel();
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);
        label.setText("Chest");

        label = new JLabel();
        label.setSize(160, 40);
        label.setLocation(10, 60);
        add(label);
        chestNameLabel = label;

        JButton button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 110);
        add(button);
        button.setText("Remove");
        JButton removeButton = button;

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapEditingScene.destroy();
            }
        });

    }

    private void dataToView(){
        chestNameLabel.setText(chest.getEquipment().getName());
    }
}
