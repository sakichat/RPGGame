package ui.panel;

import javafx.scene.layout.Pane;
import ui.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * This Panel class sets a template for other panels which extends View calss
 * @author Siyu Chen
 * @version 0.1
 */
public class Panel extends View {

    public JLabel titleLabel;
    public String title;

    /**
     * This is a constructor
     */
    public Panel() {
        setLayout(null);

        init();
        initHeader();
        initSubviews();
    }

    /**
     * This method init background color of the whole View
     */
    protected void init() {
        setLayout(null);

        setBackground(new Color(0xFFFFFF));
    }

    /**
     * This method init the navigator title bar of this view
     */
    protected void initHeader() {
        View headerView = new View();
        headerView.setSize(getWidth(), 20);
        headerView.setLocation(0, 0);
        add(headerView);
        setBackground(new Color(0xF4F4F4));


        headerView.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = new Point();
                point.setLocation(
                        e.getX() + Panel.this.getX(),
                        e.getY() + Panel.this.getY()
                );

                Panel.this.setLocation(point);

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


        titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setSize(getWidth(), 20);
        titleLabel.setLocation(0, 0);
        headerView.add(titleLabel);
    }

    /**
     * This method calls the one in its subclasses
     */
    protected void initSubviews() {

    }
}
