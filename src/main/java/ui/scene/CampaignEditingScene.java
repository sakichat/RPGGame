package ui.scene;

import logic.Campaign;
import logic.GameMap;
import ui.panel.MapConnectionPanel;
import ui.panel.MapDelegate;
import ui.panel.MapSelectorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Penelope on 17/2/28.
 */
public class CampaignEditingScene extends Scene implements MapDelegate {

    private Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @Override
    protected void init() {
        super.init();

        title = "Edit Campaign";
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    protected void initSubviews() {

        MapSelectorPanel mapSelectorPanel = new MapSelectorPanel();
        mapSelectorPanel.setLocation(0,0);
        contentView.add(mapSelectorPanel);

        MapConnectionPanel mapConnection = new MapConnectionPanel();
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

    @Override
    public void mapSelectorPerformAction(MapSelectorPanel mapSelectorPanel, GameMap gameMap) {



    }
}
