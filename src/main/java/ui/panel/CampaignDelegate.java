package ui.panel;

import logic.Campaign;

/**
 * Created by thereaghostflash on 2017-03-02.
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
