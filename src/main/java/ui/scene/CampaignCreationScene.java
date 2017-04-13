package ui.scene;

import logic.Campaign;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to layout the campaign creation scene.
 * @author Siyu Chen
 * @version 0.3
 */
public class CampaignCreationScene extends Scene {

    /**
     * property campaign and getter & setter
     */
    private Campaign campaign;

    /**
     * Getter of campaign
     * @return
     */
    public Campaign getCampaign() {
        return campaign;
    }

    /**
     * Setter of campaign
     * @param campaign Campaign
     */
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    /**
     * Constructor
     */
    @Override
    protected void init() {
        super.init();

        title = "Create Campaign";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }

    /**
     * Layout
     */
    protected void initSubviews() {
        JLabel nameLabel = new JLabel("Name", JLabel.RIGHT);
        nameLabel.setSize(120, 40);
        nameLabel.setLocation(20, 20);
        contentView.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(160,40);
        nameField.setLocation(150, 20);
        contentView.add(nameField);

        JButton createButton = new JButton("Create");
        createButton.setSize(160, 40);
        createButton.setLocation(150, 90);
        contentView.add(createButton);

        repaint();

        backButton.addActionListener(e -> CampaignCreationScene.this.navigationView.pop());

        createButton.addActionListener(e -> {
            CampaignEditingScene campaignEditingScene = new CampaignEditingScene();
            Campaign campaign = new Campaign();
            campaign.setName(nameField.getText());
            campaignEditingScene.setCampaign(campaign);
            CampaignCreationScene.this.navigationView.push(campaignEditingScene);
        });
    }
}
