package ui.view;

import logic.effect.EffectBurning;
import logic.effect.EffectFreezing;
import logic.map.Entrance;
import logic.map.Exit;
import logic.map.GameMap;
import logic.map.Point;
import logic.player.Player;

/**
 * Created by Penelope on 2017-04-09.
 */
public class Simulation {
    public static Player player() {
        Player player = new Player();
        player.setPlayerParty(Player.PLAYER_PARTY_PLAYER);
        player.setPlayerType(Player.PLAYER_TYPE_BULLY);
        player.setName("Test");
        player.setTotalHp(30);
        player.setLevel(3);
        player.setLocation(new Point(1, 1));

        return player;
    }

    public static GameMap gameMap() {
        Player player = new Player();
        GameMap gameMap = new GameMap();

        gameMap.setWidth(12);
        gameMap.setHeight(12);

        Exit exit = new Exit();
        Entrance entrance = new Entrance();

        gameMap.addCell(exit, new Point(1, 10));
        gameMap.addCell(entrance, new Point(10, 1));
        gameMap.addCell(player, player.getLocation());

        player.setTotalHp(10);
        player.setPlayerType(Player.PLAYER_TYPE_BULLY);
        player.setPlayerParty(Player.PLAYER_PARTY_PLAYER);
        player.addEffect(new EffectFreezing());
        player.addEffect(new EffectBurning());

        return gameMap;
    }
}
