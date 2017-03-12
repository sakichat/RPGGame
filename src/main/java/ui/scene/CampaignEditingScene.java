package ui.scene;

import logic.Campaign;
import logic.GameMap;
import persistence.CampaignFileManager;
import ui.panel.MapConnectionPanel;
import ui.panel.MapDelegate;
import ui.panel.MapSelectorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a subclass of Scene and implements the interface MapDelegate.
 * @author Siyu Chen
 * @version 0.1
 */
public class CampaignEditingScene extends Scene implements MapDelegate {

    /**
     * property campaign and getter & setter
     */
    private Campaign campaign;

    /**
     * this is a getter method
     * @return Campaign
     */
    public Campaign getCampaign() {
        return campaign;
    }

    /**
     * this is a setter method
     * @param campaign
     */
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

    private MapConnectionPanel mapConnectionPanel;

    /**
     * Set layout
     */
    protected void initSubviews() {

        MapSelectorPanel mapSelectorPanel = new MapSelectorPanel();
        mapSelectorPanel.setLocation(20,20);
        mapSelectorPanel.setButtonText("Add");
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

    /**
     * The save method, used to save the object to file.
     */
    public void save() {
        CampaignFileManager.save(campaign);
        navigationView.popTo(EditorScene.class);
    }

    /**
     * Implements the method in delegtion method.
     * @param mapSelectorPanel MapSelectorPanel
     * @param gameMap GameMap
     */
    @Override
    public void mapSelectorPerformAction(MapSelectorPanel mapSelectorPanel, GameMap gameMap) {
        campaign.addMapName(gameMap.getName());
        mapConnectionPanel.dataToView();
    }
}
