package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-02.
 * @author GU_HAN
 * @version 0.2
 *
 * This class is for validate the campaign.
 */
public class CampaignTest {
    /**
     * This parameter is to define a campaign that can be used in every method here.
     */
    private Campaign testCampaign = new Campaign();

    /**
     * This method is for initializing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        String gameMapName1 = "Howling Abeiase";
        String gameMapName2 = "Summoner's Rift";
        String gameMapName3 = "Salty Lake";
        String gameMapName4 = "Crystal Land";

        testCampaign.addMapName(gameMapName1);
        testCampaign.addMapName(gameMapName2);
        testCampaign.addMapName(gameMapName3);
        testCampaign.addMapName(gameMapName4);

    }

    /**
     * This case tests a valid campaign.
     * @throws Exception
     */
    @Test
    public void testValidCampaign() throws Exception{
        Assert.assertEquals(Campaign.VALIDATION_SUCCESS, testCampaign.validate());
    }

    /**
     * This case tests an invalid campaign.
     * @throws Exception
     */
    @Test
    public void testInvalidCampaign() throws Exception{
        Campaign campaign = new Campaign();

        Assert.assertEquals(Campaign.VALIDATION_ERROR_NO_MAP, campaign.validate());
    }
}