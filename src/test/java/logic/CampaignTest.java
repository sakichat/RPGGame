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
    private Campaign testCampaign;

    /**
     * This method is for setting up.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Campaign campaign = new Campaign();

        String gameMapName1 = "Howling Abeiase";
        String gameMapName2 = "Summoner's Rift";
        String gameMapName3 = "Salty Lake";
        String gameMapName4 = "Crystal Land";

        campaign.addMapName(gameMapName1);
        campaign.addMapName(gameMapName2);
        campaign.addMapName(gameMapName3);
        campaign.addMapName(gameMapName4);

        testCampaign = campaign;
    }

    /**
     * This case tests a correct campaign.
     * @throws Exception
     */

    @Test
    public void testValidCampaign() throws Exception{
        Assert.assertEquals(Campaign.VALIDATION_SUCCESS, testCampaign.validate());
    }

    /**
     * This case tests a wrong campaign.
     * @throws Exception
     */
    @Test
    public void testUnvalidCampaign() throws Exception{
        Campaign campaign = new Campaign();

        Assert.assertEquals(Campaign.VALIDATION_ERROR_NO_MAP, campaign.validate());
    }


}