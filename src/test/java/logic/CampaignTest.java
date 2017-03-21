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

    private Campaign campaignTest;

    /**
     * This method is for setting up.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Campaign campaign = new Campaign();

        String gameMap1 = "Howling Abeiase";
        String gameMap2 = "Summoner's Rift";
        String gameMap3 = "Salty Lake";
        String gameMap4 = "Crystal Land";

        campaign.addMapName(gameMap1);
        campaign.addMapName(gameMap2);
        campaign.addMapName(gameMap3);
        campaign.addMapName(gameMap4);

        campaignTest = campaign;
    }

    /**
     * This case tests a correct campaign.
     * @throws Exception
     */

    @Test
    public void testCorrectCampaign() throws Exception{
        Assert.assertEquals(Campaign.VALIDATION_SUCCESS, campaignTest.validate());
    }

    /**
     * This case tests a wrong campaign.
     * @throws Exception
     */
    @Test
    public void testWrongCampaign() throws Exception{
        Campaign campaign = new Campaign();

        Assert.assertEquals(Campaign.VALIDATION_ERROR_NO_MAP, campaign.validate());
    }


}