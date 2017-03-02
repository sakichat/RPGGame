package map.validator;

import map.MapValidator;

/**
 * Created by Saki on 2017/2/20.
 */
public class MapValidatorExit extends MapValidator{
   
    @Override
    public boolean validate() {
        if (gameMap.getExits() != null && gameMap.getExits().size() == 1){
            return true;
        }

        return false;
    }
}
