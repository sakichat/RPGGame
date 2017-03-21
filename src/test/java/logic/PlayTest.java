package logic;

import org.junit.Assert;
import org.junit.Test;
import persistence.CampaignFileManager;
import persistence.PlayerFileManager;

/**
 * Created by GU_HAN on 2017-03-20.
 * @author GU_HAN
 * @version 0.2
 */
public class PlayTest {
    /**
     * This method is to test if the player will move out of border.
     * @throws Exception
     */
    @Test
    public void moveTest() throws Exception {
        Campaign campaign = CampaignFileManager.read("caribean_sea");
        Player player = PlayerFileManager.read("asheley");
        Play play = new Play();
        play.setCampaign(campaign);
        play.setPlayer(player);
        play.resolveMap();
        play.setDirection(Point.DIRECTION_RIGHT);
        System.out.println(play.getPlayer().getLocation());

        play.move();
        play.move();
        play.move();

        System.out.println(play.getPlayer().getLocation());

        Assert.assertEquals(new Point(4, 3), play.getPlayer().getLocation());
    }

    /**
     * This method tests if the player will move into the obstacle.
     * @throws Exception
     */
    @Test
    public void cannotMoveTest() throws Exception {
        Campaign campaign = CampaignFileManager.read("caribean_sea");
        Player player = PlayerFileManager.read("asheley");
        Play play = new Play();
        play.setCampaign(campaign);
        play.setPlayer(player);
        play.resolveMap();
        play.setDirection(Point.DIRECTION_LEFT);
        System.out.println(play.getPlayer().getLocation());

        play.move();
        play.move();
        play.setDirection(Point.DIRECTION_UP);
        play.move();

        System.out.println(play.getPlayer().getLocation());

        Assert.assertEquals(new Point(0, 3), play.getPlayer().getLocation());
    }

    @Test
    public void moveToNextCell() throws Exception {
        

    }
}