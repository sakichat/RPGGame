package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a template of all other view classes which extends JPanel class
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

    /**
     * This method is for the subclass to call displayed views
     */
    protected void viewDidDisplay() {

    }

    /**
     * This method overrides the add() method in JPanel class
     * @param comp
     * @return result
     */
    @Override
    public Component add(Component comp) {
        Component result = super.add(comp, 0);
        this.repaint();
        return result;
    }

    /**
     * This method overrides the remove() method in JPanel class
     * @param comp
     */
    @Override
    public void remove(Component comp) {
        super.remove(comp);
        this.repaint();
    }

    /**
     * This is a parameter for NavigationView class
     */
    protected NavigationView navigationView;

    /**
     * getter
     * @return NavigationView
     */
    public NavigationView getNavigationView() {
        return navigationView;
    }

    /**
     * setter
     * @param navigationView
     */
    public void setNavigationView(NavigationView navigationView) {
        this.navigationView = navigationView;
    }
}
