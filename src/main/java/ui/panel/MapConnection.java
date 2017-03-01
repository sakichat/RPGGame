package ui.panel;

import javax.swing.*;

/**
 * Created by Penelope on 17/2/28.
 */
public class MapConnection extends Panel {
    @Override
    protected void init() {
        super.init();

        setSize(640, 500);
        title = "Map Connection";
    }

    private JLabel label;

    protected void initSubviews() {
        label = new JLabel("ID", JLabel.RIGHT);
        label.setSize(40, 40);
        label.setLocation(100, 30);
        add(label);

        label = new JLabel("Map Name", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(150, 30);
        add(label);

        label = new JLabel("Exit Connection", JLabel.LEFT);
        label.setSize(160, 40);
        label.setLocation(320, 30);
        add(label);
    }
}
