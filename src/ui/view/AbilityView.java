package ui.view;

import javax.swing.*;

/**
 * Created by Kai QI on 2017/2/24.
 */
public class AbilityView extends JPanel {

    public JLabel nameLabel;
    public JLabel scoreLabel;
    public JLabel modifierLabel;

    public AbilityView() {
        this.setLayout(null);
        this.setSize(160, 20);

        initSubviews();
    }

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
