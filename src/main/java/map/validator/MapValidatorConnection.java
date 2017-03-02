package map.validator;

import map.Campaign;
import map.MapValidator;

/**
 * Created by Saki on 2017/3/2.
 */
public class MapValidatorConnection extends MapValidator{
    Campaign campaign = new Campaign();

    @Override
    public boolean validate() {
        return campaign.mapValidatorConnection();
    }
}
