package ui.scene;

import ui.controlView.*;
import ui.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kai QI on 2017/2/28.
 */
public class MapEditingScene extends Scene {
    private MainControlView mainControlView;
    private WallControlView wallControlView;
    private EntranceControlView entranceControlView;
    private ExitControlView exitControlView;
    private PlayerControlView playerControlView;
    private ChestControlView chestControlView;

    private View view;

    @Override
    protected void init() {
        super.init();

        title = "The Lake of Death";
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    protected void initSubviews() {
        mainControlView = new MainControlView();
        mainControlView.setLocation(820, 40);
        add(mainControlView);

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
                MapEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });
    }

    public void save() {

    }

}
