package ui.panel;

import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Panel extends View {
    public int w;
    public int h;
    public JPanel header;

    public Panel() {
        setLayout(null);

        init();
        initSize();
        initHeader();
        initSubviews();
    }

    protected void init() {

    }

    protected void initSize() {
        setSize(w, h);
        setBackground(new Color(0xFFFFFF));
    }

    protected void initHeader() {
        header = new JPanel();
        setSize(w, 40);
        setLocation(0, 0);

        setBackground(new Color(0xF4F4F4));
    }

    protected void initSubviews() {

    }
}
