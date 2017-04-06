package logic;

import logic.player.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-31.
 * @author GU_HAN
 * @version 0.2
 *
 * This class tests the Builder pattern correctly assigns ability scores.
 */
public class PlayerExplorerTest {
    /**
     * This parameter is for pre-defined playerExplorer.
     */
    private PlayerExplorer playerExplorer;

    /**
     * This method is for initializing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        playerExplorer = new PlayerExplorer();
    }

    /**
     * This case tests the tank favors survival by a high constitution score.
     * @throws Exception
     */
    @Test
    public void getTankPlayer() throws Exception {
        playerExplorer.setPlayerBuilder(new PlayerBuilderTank());
        playerExplorer.constructPlayer("test", 5);
        Player player = playerExplorer.getPlayer();
        int playerCon = player.getAbilityScore(Player.ABILITY_CON);
        int playerDex = player.getAbilityScore(Player.ABILITY_DEX);
        int playerStr = player.getAbilityScore(Player.ABILITY_STR);
        int playerInt = player.getAbilityScore(Player.ABILITY_INT);
        int playerCha = player.getAbilityScore(Player.ABILITY_CHA);
        int playerWis = player.getAbilityScore(Player.ABILITY_WIS);

        System.out.println(playerCon + " " + playerDex + " " + playerStr + " " + playerInt + " " + playerCha + " " + playerWis);

        Assert.assertEquals(true, playerCon >= playerDex);
        Assert.assertEquals(true, playerDex >= playerStr);
        Assert.assertEquals(true, playerStr >= playerInt);
        Assert.assertEquals(true, playerInt >= playerCha);
        Assert.assertEquals(true, playerCha >= playerWis);
    }

    /**
     * This case tests a bully uses brute strength.
     * @throws Exception
     */
    @Test
    public void getBullyPlayer() throws Exception {
        playerExplorer.setPlayerBuilder(new PlayerBuilderBully());
        playerExplorer.constructPlayer("test", 5);
        Player player = playerExplorer.getPlayer();
        int playerStr = player.getAbilityScore(Player.ABILITY_STR);
        int playerCon = player.getAbilityScore(Player.ABILITY_CON);
        int playerDex = player.getAbilityScore(Player.ABILITY_DEX);
        int playerInt = player.getAbilityScore(Player.ABILITY_INT);
        int playerCha = player.getAbilityScore(Player.ABILITY_CHA);
        int playerWis = player.getAbilityScore(Player.ABILITY_WIS);

        System.out.println(playerStr + " " + playerCon + " " + playerDex + " " + playerInt + " " + playerCha + " " + playerWis);

        Assert.assertEquals(true, playerStr >= playerCon);
        Assert.assertEquals(true, playerCon >= playerDex);
        Assert.assertEquals(true, playerDex >= playerInt);
        Assert.assertEquals(true, playerInt >= playerCha);
        Assert.assertEquals(true, playerCha >= playerWis);
    }

    /**
     * This case tests a nimble favors dexterity.
     * @throws Exception
     */
    @Test
    public void getNimblePlayer() throws Exception {
        playerExplorer.setPlayerBuilder(new PlayerBuilderNimble());
        playerExplorer.constructPlayer("test", 5);
        Player player = playerExplorer.getPlayer();
        int playerDex = player.getAbilityScore(Player.ABILITY_DEX);
        int playerCon = player.getAbilityScore(Player.ABILITY_CON);
        int playerStr = player.getAbilityScore(Player.ABILITY_STR);
        int playerInt = player.getAbilityScore(Player.ABILITY_INT);
        int playerCha = player.getAbilityScore(Player.ABILITY_CHA);
        int playerWis = player.getAbilityScore(Player.ABILITY_WIS);

        System.out.println(playerDex + " " + playerCon + " " + playerStr + " " + playerInt + " " + playerCha + " " + playerWis);

        Assert.assertEquals(true, playerDex >= playerCon);
        Assert.assertEquals(true, playerCon >= playerStr);
        Assert.assertEquals(true, playerStr >= playerInt);
        Assert.assertEquals(true, playerInt >= playerCha);
        Assert.assertEquals(true, playerCha >= playerWis);
    }
}