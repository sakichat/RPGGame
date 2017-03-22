package ui.view;

import javax.swing.*;

/**
 * This class is to set the lay out of ability view.
 * @author Kai QI
 * @version 0.2
 */
public class AbilityView extends View {

    public JLabel nameLabel;
    public JLabel scoreLabel;
    public JLabel modifierLabel;


    /**
     * Constructor
     */
    public AbilityView() {
        this.setSize(160, 20);

        initSubviews();
    }

    /**
     * Layout
     */
    private void initSubviews(){

        JLabel label;

        label = new JLabel("", JLabel.RIGHT);
        label.setSize(60, 20);
        label.setLocation(0, 0);
        add(label);
        nameLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(70, 0);
        add(label);
        scoreLabel = label;

        label = new JLabel();
        label.setSize(40, 20);
        label.setLocation(120, 0);
        add(label);
        modifierLabel = label;
    }
}
