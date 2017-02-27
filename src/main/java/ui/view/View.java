package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class View extends JPanel {
    public View() {
        super();
        this.setLayout(null);
//        this.setSize(1000, 600);
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

    protected ViewFlow viewFlow;

    public ViewFlow getViewFlow() {
        return viewFlow;
    }

    public void setViewFlow(ViewFlow viewFlow) {
        this.viewFlow = viewFlow;
    }
}
