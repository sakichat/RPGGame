package logic.turn;

import logic.Play;
import logic.PlayRuntime;
import logic.map.Point;
import logic.player.Player;
import org.junit.Assert;
import persistence.CampaignFileManager;
import persistence.PlayerFileManager;

/**
 * Created by GU_HAN on 2017-04-13.
 *
 * @author GU_HAN
 * @version 0.3
 */
public class TurnStrategyTest {

    /**
     * computer ai
     * @throws Exception
     */
    public void aiPlayer() throws Exception {

        Play play = new Play();
        play.setCampaign(CampaignFileManager.read("computertest"));
        play.setMainPlayer(PlayerFileManager.read("testplayer"));
        play.getMainPlayer().setStrategy(new TurnStrategyComputer());

//        PlayRuntime.currentRuntime().initiate(new PlayScene(), play);
//
//        PlayRuntime.currentRuntime().begin();

        Player player1 = PlayRuntime.currentRuntime().getPlay().currentPlayer();
//        player1.turn();
        Point location1 = player1.getLocation();
        System.out.println(location1.getX() + " " + location1.getY());
        PlayRuntime.currentRuntime().stop();

        boolean result = true;
        TurnStrategy strategy = player1.getStrategy();
        if(strategy instanceof TurnStrategyFriendly){
            result = location1.equals(new Point(1, 1))
                    ||location1.equals(new Point(2, 1))
                    ||location1.equals(new Point(3, 1))
                    ||location1.equals(new Point(0, 2))
                    ||location1.equals(new Point(1, 2))
                    ||location1.equals(new Point(2, 2));
        }else if(strategy instanceof TurnStrategyComputer){
            result = location1.equals(new Point(1, 1))
                    ||location1.equals(new Point(2, 1))
                    ||location1.equals(new Point(3, 1))
                    ||location1.equals(new Point(0, 2))
                    ||location1.equals(new Point(0, 3))
                    ||location1.equals(new Point(1, 2));
        }else if(strategy instanceof TurnStrategyAggressive){
            result = location1.equals(new Point(1, 1))
                    ||location1.equals(new Point(2, 1))
                    ||location1.equals(new Point(3, 1))
                    ||location1.equals(new Point(0, 2))
                    ||location1.equals(new Point(0, 3))
                    ||location1.equals(new Point(1, 2));
        }

        Assert.assertTrue(result);
    }
}