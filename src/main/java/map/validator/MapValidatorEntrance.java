package map.validator;

import map.MapValidator;

/**
 * Created by Saki on 2017/2/20.
 */
public class MapValidatorEntrance extends MapValidator{

    @Override
    public boolean validate() {
        if (gameMap.getEntrances() != null && gameMap.getEntrances().size() == 1) {
            return true;
        }

        return false;
    }
}
