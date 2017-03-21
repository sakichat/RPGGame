package logic;

import org.junit.Assert;
import org.junit.Test;
import persistence.CampaignFileManager;
import persistence.PlayerFileManager;

/**
 * Created by GU_HAN on 2017-03-20.
 */
public class PlayTest {

//    private Play play;
//    @Before
//    public void setUp() throws Exception {
//        Campaign campaign = CampaignFileManager.read("caribean_sea");
//        Player player = PlayerFileManager.read("asheley");
//        Play play = new Play();
//        play.setCampaign(campaign);
//        play.setPlayer(player);
//        play.setDirection(new Point(1, 0));
//
//        this.play = play;
//
//    }

    @Test
    public void moveTest() throws Exception {
        Campaign campaign = CampaignFileManager.read("caribean_sea");
        Player player = PlayerFileManager.read("asheley");
        Play play = new Play();
        play.setCampaign(campaign);
        play.setPlayer(player);
        play.setDirection(Point.DIRECTION_LEFT);
        play.resolveMap();
        System.out.println(play.getPlayer().getLocation());

        play.move();
//        play.move();
//        play.move();

        System.out.println(play.getPlayer().getLocation());

        Assert.assertEquals(true, true);
    }

    @Test
    public void cannotMoveTest() throws Exception {

    }
}