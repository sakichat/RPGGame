package ui.panel;

import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Panel extends JPanel {
    public int w;
    public int h;
    public JPanel header;
    public JLabel panelTitle;
    public String titleName;

    public Panel() {
        setLayout(null);

        init();
        initSize();
        initHeader();
        initSubviews();
    }

    protected void init() {
        setLayout(null);
    }

    protected void initSize() {
        setSize(w, h);
        setBackground(new Color(0xFFFFFF));
    }

    protected void initHeader() {
        header = new JPanel();
        header.setSize(w, 20);
        header.setLocation(0, 0);
        add(header);
        setBackground(new Color(0xF4F4F4));

        panelTitle = new JLabel(titleName, JLabel.CENTER);
        panelTitle.setSize(w, 20);
        panelTitle.setLocation(0, 0);
        header.add(panelTitle);
    }

    protected void initSubviews() {

    }
}
