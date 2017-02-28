package ui.panel;

import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Panel extends JPanel {

    public JLabel titleLabel;
    public String title;

    public Panel() {
        setLayout(null);

        init();
        initHeader();
        initSubviews();
    }

    protected void init() {
        setLayout(null);
    }


    protected void initHeader() {
        View headerView = new View();
        headerView.setSize(getWidth(), 20);
        headerView.setLocation(0, 0);
        add(headerView);
        setBackground(new Color(0xF4F4F4));

        titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setSize(getWidth(), 20);
        titleLabel.setLocation(0, 0);
        headerView.add(titleLabel);
    }

    protected void initSubviews() {

    }
}
