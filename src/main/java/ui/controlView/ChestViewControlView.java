package ui.controlView;

import logic.map.Chest;

import javax.swing.*;

/**
 * This class for viewing chest inside during play
 * @author Siyu Chen
 * @version 0.3
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
        JButton button;

        label = new JLabel("Chest");
        label.setSize(160, 40);
        label.setLocation(10, 10);
        add(label);

        button = new JButton("View Inside");
        button.setSize(160, 40);
        button.setLocation(10, 60);
        add(button);
        JButton viewInsideButton = button;

        viewInsideButton.addActionListener(e -> playScene.showChestInspector(chest));

    }

}
