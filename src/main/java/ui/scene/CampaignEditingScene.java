package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Penelope on 17/2/28.
 */
public class CampaignEditingScene extends Scene {
    private JButton button;

    @Override
    protected void init() {
        super.init();

        title = "Edit Campaign";
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    protected void initSubviews() {
        JPanel mapConnection = new JPanel();
        mapConnection.setSize(640, 520);
        mapConnection.setLocation(330, 20);
        contentView.add(mapConnection);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CampaignEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
                CampaignEditingScene.this.navigationView.popTo(EditorScene.class);
            }
        });

    }

    public void save() {

    }
}
