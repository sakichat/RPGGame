package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-02.
 */
public class CampaignTest {
    @Before
    public void setUp() throws Exception {

    }

    /*
     * This case tests a correct campaign.
     */
    @Test
    public void testCorrectCampaign() throws Exception{
        Assert.assertEquals(Campaign.VALIDATION_SUCCESS, Simulation.campaign1().validate());
    }

    /*
     * This case tests a wrong campaign.
     */
    @Test
    public void testWrongCampaign() throws Exception{
        Campaign campaign = new Campaign();

        Assert.assertEquals(Campaign.VALIDATION_ERROR_NO_MAP, Simulation.campaign1().validate());
    }


}