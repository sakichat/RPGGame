package ui.view;

import java.awt.*;

/**
 * This GlassView is a class that sets background color as transparent which extends View
 * @author Siyu Chen
 * @version 0.3
 */
public class GlassView extends View {

    /**
     * constructor
     */
    public GlassView() {
        setBackground(new Color(0, 0, 0, Color.TRANSLUCENT));
    }
}
