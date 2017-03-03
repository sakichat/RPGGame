package ui.scene;

import logic.Campaign;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to layout the campaign creation scene.
 * @author Siyu Chen
 * @version 0.1
 */
public class CampaignCreationScene extends Scene {

    /**
     * property campaign and getter & setter
     */
    private Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CampaignCreationScene.this.navigationView.pop();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CampaignEditingScene campaignEditingScene = new CampaignEditingScene();
                Campaign campaign = new Campaign();
                campaign.setName(nameField.getText());
                campaignEditingScene.setCampaign(campaign);
                CampaignCreationScene.this.navigationView.push(campaignEditingScene);
            }
        });
    }
}
