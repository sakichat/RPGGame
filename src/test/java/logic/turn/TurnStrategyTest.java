package logic.turn;

import logic.Play;
import logic.PlayRuntime;
import logic.map.Point;
import logic.player.Player;
import org.junit.Before;
import org.junit.Test;
import persistence.CampaignFileManager;
import persistence.PlayerFileManager;
import ui.scene.PlayScene;

/**
 * Created by GU_HAN on 2017-04-13.
 */
public class TurnStrategyTest {

    @Before
    public void setUp() throws Exception {

    }

    /**
     * computer ai
     * @throws Exception
     */
    @Test
    public void aiPlayer() throws Exception {

        Play play = new Play();
        play.setCampaign(CampaignFileManager.read("humantest"));
        play.setMainPlayer(PlayerFileManager.read("testplayer"));
        play.getMainPlayer().setStrategy(new TurnStrategyComputer());

        PlayRuntime.currentRuntime().initiate(new PlayScene(), play);

        PlayRuntime.currentRuntime().begin();

        Player player1 = PlayRuntime.currentRuntime().getPlay().currentPlayer();
        Point location1 = player1.getLocation();
        System.out.println(location1.getX() + " " + location1.getY());
        player1.turn();

        Player player2 = PlayRuntime.currentRuntime().getPlay().currentPlayer();
        Point location2 = player2.getLocation();
        System.out.println(location2.getX() + " " + location2.getY());
        player2.turn();

        Player player3 = PlayRuntime.currentRuntime().getPlay().currentPlayer();
        Point location3 = player3.getLocation();;
        System.out.println(location3.getX() + " " + location3.getY());
        player3.turn();
    }

}