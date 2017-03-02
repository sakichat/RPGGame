package demo.map;

import game.Simulation;
import map.GameMap;
import map.Point;
import map.validator.MapValidatorExit;

/**
 * Created by Saki on 2017/3/1.
 */
public class MapValidatorExitDemo {
    public static void main(String[] args) {
        GameMap gameMap3 = Simulation.gameMap1();

        Point point = new Point(1, 1);
        gameMap3.removeCell(point);

        MapValidatorExit mapValidatorExit = new MapValidatorExit();
        mapValidatorExit.setGameMap(gameMap3);

        System.out.println(mapValidatorExit.validate());
    }
}
