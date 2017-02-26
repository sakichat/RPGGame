package ui.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Penelope on 17/2/24.
 *
 * @author Siyu Chen
 */
public class Window extends JFrame{
    private View contentView;

    public Window(View contentView) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.contentView = contentView;

        this.setResizable(false);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(contentView);
        this.setVisible(true);
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(d);
        contentView.setSize(d);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        contentView.setSize(width, height);
    }
}
