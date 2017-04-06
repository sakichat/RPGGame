package logic;

import logic.map.Point;
import logic.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persistence.CampaignFileManager;
import persistence.PlayerFileManager;

/**
 * Created by GU_HAN on 2017-03-20.
 * @author GU_HAN
 * @version 0.2
 *
 * This class tests character movement on the map.
 */
public class PlayTest {
    /**
     * These two parameters is for pre-defined attributes to be used.
     */
    private Play play;
    private Campaign campaign;
    private Player player;

    /**
     * This method is for initializing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        play = new Play();
        campaign = CampaignFileManager.read("testcampaign");
        player = PlayerFileManager.read("testplayer");

        play.setCampaign(campaign);
        play.setPlayer(player);
        play.resolveMap();
    }

    /**
     * This case tests if the player as an arttribute can be changed after moving.
     * @throws Exception
     */
    @Test
    public void moveToNextCell() throws Exception {
        play.setDirection(Point.DIRECTION_DOWN);
        Point previousLocation = play.getPlayer().getLocation();

        play.move();
        play.move();

        Point nowLocation = play.getPlayer().getLocation();
        boolean notChangeLocation = previousLocation == nowLocation;

        Assert.assertEquals(false, notChangeLocation);
}
    /**
     * This case tests if the player will move out of border.
     * @throws Exception
     */
    @Test
    public void moveBorderTest() throws Exception {
        play.setDirection(Point.DIRECTION_LEFT);
        Point previousLocation = play.getPlayer().getLocation();

        play.move();

        Point nowLocation = play.getPlayer().getLocation();

        boolean notChangeLocation = previousLocation == nowLocation;

        Assert.assertEquals(true, notChangeLocation);
    }

    /**
     * This case tests if the player will move into the obstacle.
     * @throws Exception
     */
    @Test
    public void cannotMoveTest() throws Exception {
        play.setDirection(Point.DIRECTION_RIGHT);
        System.out.println(play.getPlayer().getLocation());

        play.move();
        play.move();
        play.move();
        play.setDirection(Point.DIRECTION_DOWN);

        Point previousLocation = play.getPlayer().getLocation();

        play.move();

        Point nowLocation = play.getPlayer().getLocation();

        boolean notChangeLocation = previousLocation == nowLocation;

        Assert.assertEquals(true, notChangeLocation);
    }
}