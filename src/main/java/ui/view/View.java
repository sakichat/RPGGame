package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class View extends JPanel {

    /**
     * This is a constructor
     */
    public View() {
        super();
        this.setLayout(null);
    }

    protected void viewDidDisplay() {

    }

    @Override
    public Component add(Component comp) {
        Component result = super.add(comp, 0);
        this.repaint();
        return result;
    }

    @Override
    public void remove(Component comp) {
        super.remove(comp);
        this.repaint();
    }

    /**
     * This is a parameter for NavigationView class
     */
    protected NavigationView navigationView;

    public NavigationView getNavigationView() {
        return navigationView;
    }

    public void setNavigationView(NavigationView navigationView) {
        this.navigationView = navigationView;
    }
}
