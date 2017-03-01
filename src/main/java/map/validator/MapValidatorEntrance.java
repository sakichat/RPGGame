package map.validator;

import map.GameMap;
import map.MapValidator;

/**
 * Created by Saki on 2017/2/20.
 */
public class MapValidatorEntrance extends MapValidator{
    GameMap gameMap = new GameMap();

    @Override
    public boolean validate() {
        if (gameMap.getEntrances() != null) {
            return true;
        }

        return false;
    }
}
