package ui.panel;

import logic.Campaign;

/**
 * @author Li Zhen
 * @version 0.1
 * this is the CampaignDelegate implements
 */
public interface CampaignDelegate {
    /**
     * this method is to give the two patameters
     * @param campaignSelectorPanel CampaignSelectorPanel
     * @param campaign Campaign
     */
    void campaignSelectorPerformAction(CampaignSelectorPanel campaignSelectorPanel, Campaign campaign);
}
