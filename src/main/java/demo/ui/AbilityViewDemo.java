package demo.ui;

import ui.view.AbilityView;

import javax.swing.*;

/**
 * Created by Saki on 2017/2/24.
 */
public class AbilityViewDemo extends JFrame{

    public static void main(String[] args) {
        AbilityViewDemo window = new AbilityViewDemo();
        window.setSize(200, 50);
        window.setLayout(null);
        window.setVisible(true);
    }

    public AbilityViewDemo() {
        AbilityView abilityView = new AbilityView();
        this.add(abilityView);

        abilityView.nameLabel.setText("HAHAHA");
        abilityView.scoreLabel.setText("HAHAHA");
        abilityView.modifierLabel.setText("HAHAHA");
    }
}
