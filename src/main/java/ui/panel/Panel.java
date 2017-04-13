package ui.panel;

import ui.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This Panel class sets a template for other panels which extends View calss
 * @author Siyu Chen
 * @version 0.3
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

        ImageIcon closeButton = new ImageIcon("data/images/close_button.png");

        JButton closePanelButton = new JButton(closeButton);
        closePanelButton.setSize(20, 20);
        closePanelButton.setBorderPainted(false);
        closePanelButton.setLocation(getWidth() - 20, 0);
        headerView.add(closePanelButton);

        closePanelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Container parent = Panel.this.getParent();
                parent.remove(Panel.this);
                parent.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        class DragHandle implements MouseListener, MouseMotionListener{
            int x;
            int y;

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = e.getX() - x;
                int dy = e.getY() - y;

                Point location = Panel.this.getLocation();
                location.translate(dx, dy);
                Panel.this.setLocation(location);

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        }

        DragHandle dragHandle = new DragHandle();

        headerView.addMouseMotionListener(dragHandle);
        headerView.addMouseListener(dragHandle);



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
