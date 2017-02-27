package ui.panel;

import ui.view.View;

import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Panel extends View {
    public int w;
    public int h;

    public Panel() {
        this.setLayout(null);

        this.initSize();
        this.initHeader();
    }

    public void initSize() {
        setSize(w, h);
        setBackground(new Color(0xFFFFFF));
    }

    public void initHeader() {
        setSize(w, 40);
        setLocation(0, 0);

        setBackground(new Color(0xF4F4F4));
    }
}
