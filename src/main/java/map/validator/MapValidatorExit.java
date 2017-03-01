package map.validator;

import map.GameMap;
import map.MapValidator;

/**
 * Created by Saki on 2017/2/20.
 */
public class MapValidatorExit extends MapValidator{
    GameMap gameMap = new GameMap();

    @Override
    public boolean validate() {
        if (gameMap.getExits() != null && gameMap.getExits().size() < 2){
            return true;
        }

        return false;
    }
}
