package ui.scene;

import logic.Campaign;
import logic.GameMap;
import persistence.CampaignFileManager;
import ui.panel.MapConnection;
import ui.panel.MapConnectionPanel;
import ui.panel.MapDelegate;
import ui.panel.MapSelectorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Penelope on 17/2/28.
 */
public class CampaignEditingScene extends Scene implements MapDelegate {

    /**
     * property campaign and getter & setter
     */
    private Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
        mapConnectionPanel.setCampaign(campaign);
        mapConnectionPanel.dataToView();
    }

    /**
     * Constructor
     */
    @Override
    protected void init() {
        super.init();

        title = "Edit Campaign";
        backButtonEnabled = true;
        saveButtonEnabled = true;
    }

    /**
     * Set layout
     */

    private MapConnectionPanel mapConnectionPanel;

    protected void initSubviews() {

        MapSelectorPanel mapSelectorPanel = new MapSelectorPanel();
        mapSelectorPanel.setLocation(20,20);
        contentView.add(mapSelectorPanel);

        mapConnectionPanel = new MapConnectionPanel();
        mapConnectionPanel.setLocation(330, 20);
        contentView.add(mapConnectionPanel);

        mapSelectorPanel.setMapDelegate(this);

        repaint();

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
        CampaignFileManager.save(campaign);
        navigationView.popTo(EditorScene.class);
    }

    @Override
    public void mapSelectorPerformAction(MapSelectorPanel mapSelectorPanel, GameMap gameMap) {
        campaign.addMapName(gameMap.getName());
        mapConnectionPanel.dataToView();
    }
}
