package logic;

import logic.Campaign;
import logic.Simulation;
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
     * This case test the ordinary sequence-like campaign.
     */
    @Test
    public void campaignConnection() throws Exception {
        Campaign campaign = Simulation.campaign1();

        Assert.assertEquals(true, campaign.validate());
    }

    /*
     * THis case test the unconnected campaign which should be false.
     */
    @Test
    public void mapValidatorConnection1() throws Exception {
        Campaign campaign = new Campaign();

        String gameMap1 = "Howling Abeiase";
        String gameMap2 = "Summoner's Rift";
        String gameMap3 = "Salty Lake";
        String gameMap4 = "Crystal Land";

        campaign.addConnection(gameMap1);
        campaign.addConnection(gameMap2);
        campaign.addConnection(gameMap3);
        campaign.addConnection(gameMap4);

        campaign.getConnection(1).setTargetId(0);
        campaign.getConnection(2).setTargetId(3);
        campaign.getConnection(3).setTargetId(4);
        campaign.getConnection(4).setTargetId(1);

        Assert.assertEquals(false, campaign.validate());
    }

    /*
     * This case tests the rounded-like campaign.
     */
    @Test
    public void mapValidatorConnection2() throws Exception {
        Campaign campaign = new Campaign();

        String gameMap1 = "Howling Abeiase";
        String gameMap2 = "Summoner's Rift";
        String gameMap3 = "Salty Lake";
        String gameMap4 = "Crystal Land";

        campaign.addConnection(gameMap1);
        campaign.addConnection(gameMap2);
        campaign.addConnection(gameMap3);
        campaign.addConnection(gameMap4);

        campaign.getConnection(1).setTargetId(2);
        campaign.getConnection(2).setTargetId(3);
        campaign.getConnection(3).setTargetId(1);
        campaign.getConnection(4).setTargetId(0);

        Assert.assertEquals(false, campaign.validate());
    }

}