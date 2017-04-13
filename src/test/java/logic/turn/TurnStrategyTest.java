package logic.turn;

import logic.Play;
import logic.PlayRuntime;
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
        play.setCampaign(CampaignFileManager.read("testcampaign"));
        play.setMainPlayer(PlayerFileManager.read("asheley"));

        PlayRuntime.currentRuntime().setPlay(play);
        PlayRuntime.currentRuntime().begin();

        PlayRuntime.currentRuntime().initiate(new PlayScene(), play);



    }

    /**
     * friendly ai
     */
    @Test
    public void friendlyPlayer() throws Exception {

    }

    @Test
    public void hostilePlayer() throws Exception {

    }

    @Test
    public void humanPlayer() throws Exception {

    }
}