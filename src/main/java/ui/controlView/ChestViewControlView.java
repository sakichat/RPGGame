package ui.controlView;

import logic.Chest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class for viewing chest inside during play
 * @author Siyu Chen
 * @version 0.2
 */
public class ChestViewControlView extends ControlView {
    /**
     * Declaration of the properties, and getter & setter
     */
    private Chest chest;

    /**
     * This is the chest getter.
     * @return
     */
    public Chest getChest() {
        return chest;
    }

    /**
     * This is the chest setter.
     * @param chest
     */
    public void setChest(Chest chest) {
        this.chest = chest;
    }

    /**
     * constructor of the View.
     */
    public ChestViewControlView() {
        this.setSize(180,560);
        initSubviews();
    }

    /**
     * layout
     */
    public void initSubviews() {

        JLabel label;

        label = new JLabel();
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);
        label.setText("Chest");

        JButton button;

        button = new JButton();
        button.setSize(160, 40);
        button.setLocation(10, 60);
        add(button);
        button.setText("View Inside");
        JButton viewInsideButton = button;

        viewInsideButton.addActionListener(e -> playScene.showChestViewInside(chest));

    }

}
