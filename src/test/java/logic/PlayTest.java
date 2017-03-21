package logic;

import org.junit.Before;
import org.junit.Test;
import persistence.CampaignFileManager;
import persistence.PlayerFileManager;

/**
 * Created by GU_HAN on 2017-03-20.
 */
public class PlayTest {
    @Before
    public void setUp() throws Exception {
        Campaign campaign = CampaignFileManager.read("caribean_sea");
        Player player = PlayerFileManager.read("asheley");
        Play play = new Play();
        play.setCampaign(campaign);
        play.setPlayer(player);
        play.setDirection(new Point(0, 1));

    }

    @Test
    public void moveTest() throws Exception {

    }

    @Test
    public void cannotMoveTest() throws Exception {

    }
}