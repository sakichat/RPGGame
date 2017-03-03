package logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-02.
 * @author GU_HAN
 * @version 0.1
 *
 * This class is for validate the campaign.
 */

public class CampaignTest {
    /**
     * This case tests a correct campaign.
     * @throws Exception
     */
    @Test
    public void testCorrectCampaign() throws Exception{
        Assert.assertEquals(Campaign.VALIDATION_SUCCESS, Simulation.campaign1().validate());
    }

    /**
     * This case tests a wrong campaign.
     * @throws Exception
     */
    @Test
    public void testWrongCampaign() throws Exception{
        Campaign campaign = new Campaign();

        Assert.assertEquals(Campaign.VALIDATION_ERROR_NO_MAP, Simulation.campaign1().validate());
    }


}